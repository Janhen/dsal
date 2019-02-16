package com.janhen.structures.queue.twoStackImpl;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Queue<E> {

    private Stack<E> pushStack;
    private Stack<E> popStack;

    public Queue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void enqueue(E e) {
        pushStack.push(e);
    }

    public E dequeue() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty())
                popStack.push(pushStack.pop());
        }

        if (popStack.isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return popStack.pop();
    }

    public E peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty())
                popStack.push(pushStack.pop());
        }

        if (popStack.isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return popStack.peek();
    }

}
