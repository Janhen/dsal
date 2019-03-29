package com.janhen.design.stackWithMin;

import com.janhen.structures.stack.baseNode.Stack;

public class GetMinStack<E extends Comparable<E>> {

    private Stack<E> data;
    private Stack<E> min;

    public GetMinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    // min push:   min{e,peek},  peek∈{null,xxx}
    public void push(E e) {
        if (min.isEmpty())
            min.push(e);
        else if (e.compareTo(min.peek()) < 0)
            min.push(e);
        else // peek <= e
            min.push(min.peek());

        data.push(e);
    }

    // pop at the same time
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
