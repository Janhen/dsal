package com.janhen.design.queueByStack;

public class Main {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();


        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        int pop1 = queue.pop();

        int peek = queue.peek();
        queue.push(5);
        queue.pop();
        queue.pop();
        int pop2 = queue.pop();


        System.out.printf("%d, %d, %d", pop1, peek, pop2);
    }
}
