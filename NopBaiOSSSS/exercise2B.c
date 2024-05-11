#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <string.h>
#include <errno.h>
#include <sys/wait.h>

// Define message structure
struct message {
    long mtype;
    int operand1;
    int operand2;
    char operator;
};

int main(int argc, char *argv[]) {
    if (argc != 4) {
        fprintf(stderr, "Usage: %s <operand1> <operand2> <operator>\n", argv[0]);
        return -1;
    }

    int operand1 = atoi(argv[1]);
    int operand2 = atoi(argv[2]);
    char operator = argv[3][0];

    // Generate key using ftok
    key_t key = ftok(".", 'a');
    if (key == -1) {
        perror("ftok");
        return -1;
    }

    // Create message queue
    int msqid = msgget(key, IPC_CREAT | 0666);
    if (msqid == -1) {
        perror("msgget");
        return -1;
    }

    // Fork a child process
    pid_t pid = fork();

    if (pid == -1) {
        perror("fork");
        return -1;
    } else if (pid == 0) {
        // Child process
        struct message msg;
        msg.mtype = 1; // Message type is 1

        // Set message fields
        msg.operand1 = operand1;
        msg.operand2 = operand2;
        msg.operator = operator;

        // Send message to parent
        if (msgsnd(msqid, &msg, sizeof(struct message) - sizeof(long), 0) == -1) {
            perror("msgsnd");
            return -1;
        }

        return 0;
    } else {
        // Parent process
        struct message msg;

        // Receive message from child
        if (msgrcv(msqid, &msg, sizeof(struct message) - sizeof(long), 1, 0) == -1) {
            perror("msgrcv");
            return -1;
        }

        // Perform calculation based on operator
        int result;
        switch (msg.operator) {
            case '+':
                result = msg.operand1 + msg.operand2;
                break;
            case '-':
                result = msg.operand1 - msg.operand2;
                break;
            case '*':
                result = msg.operand1 * msg.operand2;
                break;
            case '/':
                if (msg.operand2 == 0) {
                    fprintf(stderr, "Error: Division by zero\n");
                    return -1;
                }
                result = msg.operand1 / msg.operand2;
                break;
            default:
                fprintf(stderr, "Error: Invalid operator\n");
                return -1;
        }

        // Print result
        printf("%d %c %d = %d\n", msg.operand1, msg.operator, msg.operand2, result);

        // Write result to file
        FILE *file = fopen("result.txt", "w");
        if (file == NULL) {
            perror("fopen");
            return -1;
        }
        fprintf(file, "%d %c %d = %d\n", msg.operand1, msg.operator, msg.operand2, result);
        fclose(file);

        // Remove message queue
        if (msgctl(msqid, IPC_RMID, NULL) == -1) {
            perror("msgctl");
            return -1;
        }

        // Wait for child process to finish
        wait(NULL);
    }

    return 0;
}
