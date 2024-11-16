#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <errno.h>

#define FIFO_PATH "/tmp/myfifo"

int main(int argc, char **argv) {
    if(argc != 2) {
        printf("lack of argument");
        return -1;
    }

    int n = atoi(argv[1]);
    if (n <= 3) {
        printf("The number must be greater than 3\n");
        return -1;
    }

    // create the named pipe
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
        int fd = open(FIFO_PATH, 1); // for writing
        if (fd == -1) {
            perror("Error opening named pipe for writing");
            return -1;
        }

        int factorial = 1;
        for (int i = n; i > 0; i--) {
            factorial *= i;
        }

        if (write(fd, &factorial, sizeof(factorial)) == -1) {
            perror("Error writing to named pipe");
            return -1;
        }
        close(fd); // close pipe
        return 0;
    } else {
        int fd = open(FIFO_PATH, 0); // for reading
        if (fd == -1) {
            perror("Error opening named pipe for reading");
            return -1;
        }

        int result;
        if (read(fd, &result, sizeof(result)) == -1) {
            perror("Error reading from named pipe");
            return -1;
        }

        printf("%d != %d\n", n, result);
        close(fd); // close pipe
        wait(NULL); // wait for child process to finish
    }

    return 0;
}
