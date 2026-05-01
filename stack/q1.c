#include <stdio.h>
#include <stdlib.h>

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

void push(ST *p){
    int item;
    printf("Enter item:");
    scanf("%d",&item);
    if(overflow(p)==1){
        printf("Stck full");
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
    int choice,x;
    init(&s);

    do{
        printf("1. Push \n");
        printf("2. Pop \n" );
        printf("3. Exit \n");
        printf("Enter choice:");
        scanf("%d",&choice);

        switch(choice){
            case 1: 
            push(&s);
            break;

            case 2:
            x=pop(&s);
            if(x!=-1)
                printf("Popped element:%d",x);
            break;

            case 3:
            printf("Exiting....\n");

            default:
            printf("Invalid choice");
        }
    }while(choice!=0);
    return 0;
}