#include <stdio.h>
#include <stdlib.h>

typedef struct Queue{
    int *a;
    int MS;
    int rear, front;
}Q;

void init(Q * p){
    int n;
    printf("Enter max size of q:");
    scanf("%d", &n);
    p -> MS = n;
    p -> a = (int*)malloc(sizeof(int)*n);
    p -> rear = -1;
    p -> front = 0;
}

int full(Q*p){
    if (((p -> rear == p -> MS-1) && (p -> front == 0)) || ((p -> front == p -> rear + 1) && (p -> front != 0))){
        return 1;
    }else{
        return 0;
    }
}

int empty(Q*p){
    if(p -> rear == -1 && p -> front == 0){
        return 1;
    }else{
        return 0;
    }
}

void enqueue(Q*p, int n){
    if(full(p) == 1){
        printf("Queue is full");
        return;
    }
    p -> rear = (p -> rear + 1) % p->MS; //wrap around condition
    p -> a[p -> rear] = n;
}

int dequeue(Q*p){
    int x;
    if(empty(p) == 1){
        printf("Queue empty!");
        return -1;
    }
    x = p -> a[p -> front];
    if(p -> rear == p -> front){
        p -> rear = -1;
        p -> front = 0;
    }else if(p -> front == p -> MS - 1){
        p -> front = 0;
    }else{
        p -> front++;
    }

    return x;
}