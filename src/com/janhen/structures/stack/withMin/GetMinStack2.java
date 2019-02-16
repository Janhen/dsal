package com.janhen.structures.stack.withMin;

import com.janhen.structures.stack.BaseNode.Stack;

public class GetMinStack2<E extends Comparable<E>> {

    private Stack<E> data;
    private Stack<E> min;

    public GetMinStack2() {
        data = new Stack<>();
        min = new Stack<>();
    }

    // push e when e=min{e,peek}
    public void push(E e) {
        if (min.isEmpty())
            min.push(e);
        else if (e.compareTo(min.peek()) <= 0) // == push
            min.push(e);

        data.push(e);
    }

    public E pop() {
        if (data.isEmpty())
            throw new IllegalArgumentException("Stack is empty");

        E oldTop = data.pop();
        if (oldTop.equals(min.peek()))
          min.pop();
        return oldTop;
    }

    public E getMin() {
        if (min.isEmpty())
            return null;
        return min.peek();
    }
}
