class CustomStack {
    private int[] arr;
    private int top;
    private int capacity;

    public CustomStack(int size) {
        this.capacity = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int n) {
        if (top == capacity - 1) {
            System.out.println("Stack full!");
            return;
        }
        arr[++top] = n;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack empty!");
            return -1;
        }
        return arr[top--];
    }

    public void print() {
        if (top == -1) {
            System.out.println("Stack empty!");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Stack {
    public static void main(String[] args) {
        CustomStack myStack = new CustomStack(10);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(15);
        myStack.push(9);
        myStack.print();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.print();
    }
}
