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
    if(argc != 4) {
        printf("lack of argument");
        return -1;
    }

    int operand1 = atoi(argv[1]);
    int operand2 = atoi(argv[2]);
    char operator = argv[3][0];

    key_t key = ftok(".", 'a'); // generate key
    if (key == -1) {
        perror("ftok");
        return -1;
    }

    int msqid = msgget(key, IPC_CREAT | 0666); // create message queue
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
        struct message msg;

        if (msgrcv(msqid, &msg, sizeof(struct message) - sizeof(long), 1, 0) == -1) { //receive message
            perror("msgrcv");
            return -1;
        }

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

        printf("%d %c %d = %d\n", msg.operand1, msg.operator, msg.operand2, result);

        FILE *file = fopen("result.txt", "w"); // write result to file
        if (file == NULL) {
            perror("fopen");
            return -1;
        }
        fprintf(file, "%d %c %d = %d\n", msg.operand1, msg.operator, msg.operand2, result);
        fclose(file);
        printf("\nresult write to result.txt\n");

        
        if (msgctl(msqid, IPC_RMID, NULL) == -1) { // remove message
            perror("msgctl");
            return -1;
        }

        wait(NULL);
    }

    return 0;
}
