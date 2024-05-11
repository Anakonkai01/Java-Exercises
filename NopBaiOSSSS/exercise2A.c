#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <errno.h>
#include <string.h>

#define FIFO_PATH "/tmp/calculator_fifo"

int main(int argc, char **argv) {
    if(argc != 4) {
        printf("Usage: %s <operand1> <operand2> <operator>\n", argv[0]);
        return -1;
    }

    int operand1 = atoi(argv[1]);
    int operand2 = atoi(argv[2]);
    char operator = argv[3][0];

    // Create the named pipe
    if ((mknod(FIFO_PATH, S_IFIFO | 0666, 0) < 0) && (errno != EEXIST)) {
        perror("mknod");
        return -1;
    }

    pid_t pid;
    pid = fork();

    if (pid == -1) {
        perror("Failed to create pid");
        return -1;
    } else if (pid == 0) {
        // Child process
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

        // Send result to parent
        int fd = open(FIFO_PATH, O_WRONLY);
        if (fd == -1) {
            perror("Error opening named pipe for writing");
            return -1;
        }
        if (write(fd, &result, sizeof(result)) == -1) {
            perror("Error writing to named pipe");
            return -1;
        }
        close(fd); // close pipe
        return 0;
    } else {
        // Parent process
        int fd = open(FIFO_PATH, O_RDONLY);
        if (fd == -1) {
            perror("Error opening named pipe for reading");
            return -1;
        }

        // Read result from child
        int result;
        if (read(fd, &result, sizeof(result)) == -1) {
            perror("Error reading from named pipe");
            return -1;
        }

        // Print result
        printf("%d %c %d = %d\n", operand1, operator, operand2, result);

        // Write result to file
        FILE *file = fopen("result.txt", "w");
        if (file == NULL) {
            perror("fopen");
            return -1;
        }
        fprintf(file, "%d %c %d = %d\n", operand1, operator, operand2, result);
        fclose(file);

        close(fd); // close pipe
        wait(NULL); // wait for child process to finish
    }

    // Remove the named pipe
    unlink(FIFO_PATH);

    return 0;
}
