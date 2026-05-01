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
    printf("Enter size:");
    scanf("%d",&n);
    p -> top = -1;
    p -> MS = n;
    p -> a = (int*)malloc(sizeof(int)*n);
}

int overflow(ST *p){
    if(p -> top == p -> MS-1){
        return 1;
    }else{
        return 0;
    }
}

void push(ST *p, int item){
    if(overflow(p)==1){
        printf("Stack full");
        return;
    }
    p -> top++;
    p -> a[p -> top]=item;
}

int underflow(ST *p){
    if(p -> top == -1){
        return 1;
    }else{
        return 0;
    }
}

int pop(ST *p){
    int z;
    if(underflow(p)==1){
        printf("Stack empty");
        return;
    }
    z = p -> a[p -> top];
    p -> top--;
    return z;
}

int main(){
    ST s;
    init(&s);
    char num[50];
    printf("Enter number:");
    scanf("%s",num);
    int n = strlen(num);

    for(int i = 0; i < n; i++){
        push(&s, num[i]-'0');
    }

    while(!underflow(&s)){
        printf("%d",pop(&s));
    }
    return 0;
}