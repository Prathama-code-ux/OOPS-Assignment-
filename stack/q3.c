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

int eval(ST *p, char post[]){
    int x,y,z;
    int n = strlen(post);
    for(int i = 0; i < n; i++){
        if(post[i] >= '0' && post[i] <= '9'){
            push(p, post[i]-'0');
        }else{
            x = pop(p);
            y = pop(p);
            switch(post[i]){
                case '+': z = x + y;
                          break;

                case '*': z = x * y;
                          break;

                case '-': z = y - x;
                          break;
                        
                case '/': z = y / x;
                          break;
            }
             push(p,z);
        }
    }
    return pop(p);
}

int main(){
    ST s;
    init(&s);
    char post[50];
    printf("Enter post-fix expression:");
    scanf("%s",post);

    printf("Value of expression:%d",eval(&s, post));
    return 0;
}