#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct stack{
    int *a;
    int top;
    int MS;
}ST;

void init(ST *p){
    int n;
    printf("Enter stack size:");
    scanf("%d",&n);
    p -> top = -1;
    p -> MS = n;
    p -> a = (int*)malloc(sizeof(int)*n);
}

int overflow(ST *p){
    if(p -> top == p -> MS-1){
        printf("Overflow");
        return 1;
    }else{
        return 0;
    }
}

int underflow(ST *p){
    if(p -> top == -1){
        printf("Stack empty!");
        return 1;
    }else{
        return 0;
    }
}

void push(ST *p, int item){
    if(overflow(p) == 1){
        return;
    }
    p -> a[++p -> top] = item;
}

int pop(ST *p){
    int z;
    if(underflow(p) == 1){
        return -1;
    }
    z = p -> a[p -> top];
    p -> top--;
    return z;
}

int peek(ST *p){
    if(underflow(p) == 1){
        return -1;
    }
    return p -> a[p -> top];
}

int precedence(char op){
    if(op == '+' || op == '-')
    return 1;
    if(op == '*' || op == '/')
    return 2;
    if(op == '^')
    return 3;
    return 0;
}

int isOpen(char c){
    return c == '(' || c == '{' || c == '[';
}

int isClose(char c){
    return c == ')' || c == '}' || c == ']';
}

int isMatch(char open, char close){
    return (open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']');
}

int isBalanced(ST *p, char expr[]){
    int n = strlen(expr);
    for(int i = 0; i < n; i++){
        char c = expr[i];
        if(isOpen(c)){
            push(p, c);
        }else if(isClose(c)){
            if(p -> top == -1){ // Using p->top == -1 instead of underflow(p) to avoid printing "Stack empty!"
                return 0;
            }
            char top = (char)pop(p);
            if(!isMatch(top, c)){
                return 0;
            }
        }
    }
    if(p -> top != -1){ // Using p->top != -1 instead of !underflow(p) to avoid printing "Stack empty!"
        return 0;
    }
    return 1;
}

