// Name: Nisha Patel
// Date: 01/31/17
// File Name: shell.c
// File Description: Input/Output loop with exit using standard C. 
//                   The fork and execvp system calls to run the command as a new child process. 
//                   Shell can pass parameters to the command that it runs. 
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#define TRUE 1
#define BUFFERSIZE 256
#define DELIM " \n"
char** parseit(char* in_command);
void  forker(char** comm_and_args);
int main(){
    
  size_t size = BUFFERSIZE;  
  char *command = (char*) malloc(size);
  char ** command_list;
  const char* exit = "exit";
  const char* quit = "quit";
  //A loop that takes commands in until user exits or quits 
  while(TRUE){
    printf("READY >: ");
    //read input
    fgets(command,size, stdin);
    command_list = parseit(command);
    printf("%s\n", command);// prints the entered command

    //exits the loop 
    if(strcmp (command, exit) == 0 || strcmp(command, quit)== 0) {
      printf("%s", command);
      return 0;
    }
    forker(command_list);
  } 
  return 0;
}
//part 2

//forker(char ** comm_and_args) that uses the fork and execvp system calls to run the command as a new child process.
void forker(char** comm_and_args){
  
  int status;
  pid_t wpid;

  if(fork() != 0){
    do{
      wpid = waitpid(-1, &status, WUNTRACED);
    }while(!WIFEXITED(status) && !WIFSIGNALED(status));
  }
  else{
    if( execvp(comm_and_args[0], comm_and_args)== -1){
      perror("JShell error");
      exit(EXIT_FAILURE);
    }
    exit(EXIT_SUCCESS);
  }
}
//part 3
// char **parser(char * in_command) that takes a complete command string and returns the proper char ** array. Then pass this array into the execvp call. 
char** parseit(char* in_command){
  
  int index = 0;
  size_t size = BUFFERSIZE;
  char** commands = (char**)malloc(size);
  char* token;
  
  token = strtok(in_command, DELIM);
  while (token != NULL){
    commands[index] = token;
    index++;
    token = strtok(NULL, DELIM);
  }
  commands[index] = NULL;

  return commands;

}
