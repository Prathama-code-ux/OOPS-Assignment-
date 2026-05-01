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
}

int isOperator(char c){
    return c=='+' || c=='-' ||
           c=='*' || c=='/';
}

void infixToPostfix(ST *p, char in[], char post[]){
    int j = 0;
    int n = strlen(in);

    for(int i = 0; i < n; i++){
        char c = in[i];

        if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9'){
            post[j++] = c;
        } 
        else if(c == '('){
            push(p, c);
        }
        else if(c == ')'){
            while(!underflow(p) && peek(p) != '('){
                post[j++] = (char)pop(p);
            }
            pop(p);
        }
        else if(isOperator(c)){
            while(!underflow(p) && peek != '(' &&
                    precedence((char)peek(p)) >= precedence(c)){
                        post[j++] = (char)pop(p);
                    }
                    push(p, c);
        }
        push(p, c);
    }
    while(!underflow(p)){
        post[j++] = (char)pop(p);
    }
    post[j]!='/0';
}


int main(){

}