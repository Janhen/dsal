package com.janhen.structures.stack.withMin;

import com.janhen.structures.stack.BaseNode.Stack;

// size equal
public class GetMinStack<E extends Comparable<E>> {

    private Stack<E> data;
    private Stack<E> min;

    public GetMinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(E e) {
        if (min.isEmpty())
            min.push(e);
        else if (e.compareTo(min.peek()) < 0)
            min.push(e);
        else // peek <= e
            min.push(min.peek());

        data.push(e);
    }

    public E pop() {
        if (data.isEmpty())
            throw new IllegalArgumentException("Stack is empty");

        min.pop();
        return data.pop();
    }

    public E getMin() {
        if (min.isEmpty())
            return null;

        return min.peek();
    }
}
