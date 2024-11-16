#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>

int main(int argc, char **argv){
    if(argc != 2) {
        printf("lack of argument");
        return -1;
    }
    
    int n = atoi(argv[1]);
    if(n <= 3){
        printf("the number must greater than 3");
        return -1;
    }

    pid_t pid;
    int unnamedPipe[2];
    if(pipe(unnamedPipe) == -1){
        perror("fail to create unnamed pipe");
        return -1;
    }

    pid = fork();
    
    if(pid == -1){
        perror("fail to create pid");
        return -1;
    }
    else if(pid == 0){
        close(unnamedPipe[0]); // close read pipe
        int factorial = 1;
        for(int i = n ; i > 0 ; i--){
            factorial *= i;
        }
        if(write(unnamedPipe[1],&factorial,sizeof(factorial)) == -1){
            perror("error to write pipe");
            return -1;
        }
        close(unnamedPipe[1]);
        return 0;
    }
    else{
        close(unnamedPipe[1]); // close write pipe
        int result;
        if(read(unnamedPipe[0],&result,sizeof(result)) == -1){
            perror("error to read pipe");
            return -1;
        }
        printf("%d != %d\n",n,result);
        close(unnamedPipe[0]);
        wait(NULL); // wait for child process to finish
    }

    return 0;
}