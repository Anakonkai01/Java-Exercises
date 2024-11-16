#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <errno.h>
#include <string.h>

#define FIFO_PATH "/tmp/myfifo"

int main(int argc, char **argv) {
    if(argc != 4) {
        printf("lack of argument");
        return -1;
    }

    int operand1 = atoi(argv[1]);
    int operand2 = atoi(argv[2]);
    char operator = argv[3][0];

    if ((mknod(FIFO_PATH, S_IFIFO | 0666, 0) < 0) && (errno != EEXIST)) { // create named pipe
        perror("mknod");
        return -1;
    }

    pid_t pid;
    pid = fork();

    if (pid == -1) {
        perror("Failed to create pid");
        return -1;
    } else if (pid == 0) {
        int result;
        switch(operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    printf("Error: Division by zero\n");
                    return -1;
                }
                result = operand1 / operand2;
                break;
            default:
                printf("Error: Invalid operator\n");
                return -1;
        }

        int fd = open(FIFO_PATH, 1); // write 
        if (fd == -1) {
            perror("Error opening named pipe for writing");
            return -1;
        }
        if (write(fd, &result, sizeof(result)) == -1) {
            perror("Error writing to named pipe");
            return -1;
        }
        close(fd); 
        return 0;
    } else {
        int fd = open(FIFO_PATH, 0);
        if (fd == -1) {
            perror("Error opening named pipe for reading"); // read
            return -1;
        }

        int result;
        if (read(fd, &result, sizeof(result)) == -1) {
            perror("Error reading from named pipe");
            return -1;
        }

        printf("%d %c %d = %d\n", operand1, operator, operand2, result);

        FILE *file = fopen("result.txt", "w");
        if (file == NULL) {
            perror("fopen");
            return -1;
        }
        fprintf(file, "%d %c %d = %d\n", operand1, operator, operand2, result);
        fclose(file);
        printf("\nresult write to result.txt\n");

        close(fd); 
        wait(NULL); // wait for child process to finish
    }

    return 0;
}
