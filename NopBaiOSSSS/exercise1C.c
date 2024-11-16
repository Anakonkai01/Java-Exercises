#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>

#define BUFFER 4096

struct message_buffer {
    long message_type;
    int message_data;
};

int main(int argc, char **argv) {
    if (argc != 2) {
        printf("lack of argument\n");
        return -1;
    }

    int n = atoi(argv[1]);
    if (n <= 3) {
        printf("the number must be greater than 3\n");
        return -1;
    }

    pid_t pid;
    key_t key;
    int message_id;
    struct message_buffer message;

    
    if ((key = ftok(".", 'a')) == -1) { // generate a unique key
        perror("ftok");
        return -1;
    }

    
    if ((message_id = msgget(key, 0666 | IPC_CREAT)) == -1) { // create message queue
        perror("msgget");
        return -1;
    }

    pid = fork();

    if (pid == -1) {
        perror("fail to create pid");
        return -1;
    } else if (pid == 0) {
        message.message_type = 1;
        int factorial = 1;
        for (int i = n; i > 0; i--) {
            factorial *= i;
        }
        message.message_data = factorial;

        if (msgsnd(message_id, &message, BUFFER, 0) == -1) { // Send message
            perror("msgsnd");
            return -1;
        }
        return 0;
    } else {
        if (msgrcv(message_id, &message, BUFFER, 1, 0) == -1) { // receive message 
            perror("msgrcv");
            return -1;
        }
        printf("%d != %d\n", n, message.message_data);

        if (msgctl(message_id, IPC_RMID, NULL) == -1) { // delete the message queue
            perror("msgctl");
            return -1;
        }

        wait(NULL); // wait for child process to finish
    }

    return 0;
}
