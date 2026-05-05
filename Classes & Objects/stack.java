
import java.util.Scanner;

class CustomStack{
    private int[] arr; //only be accessed inside the same class 
    private int top;
    private int capacity;

    //constructor 
    public CustomStack(int size){
        this.capacity = size;
        this.arr = new int[size];
        this.top = -1; //indicates empty stack
    }

    //push: adding an element to the top
    public void push(int n){
        if(top == capacity-1){
            System.out.println("Stack full!");
            return;
        }
        arr[++top] = n;
    }

    public int pop(){
        if(top == -1){
            System.out.println("Stack empty!");
            return -1;
        }
        return arr[top--];
    }

    public void print(){
        if(top == -1){
            System.out.println("Stack empty!");
            return;
        }

        for(int i = top; i >= 0; i--){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Stack{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the max size of the stack:");
        int num = sc.nextInt();

        //create a stack to hold a max of 10 integers
        CustomStack myStack = new CustomStack(num);

        //push the numbers 10,20,30,15,9
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(15);
        myStack.push(9);

        //print the stack
        System.out.println("Current stack:");
        myStack.print();

        //pop thrice
        myStack.pop();
        myStack.pop();
        myStack.pop();

        //print stack again
        System.out.println("Stack after pop:");
        myStack.print();

        sc.close();
    }
}
