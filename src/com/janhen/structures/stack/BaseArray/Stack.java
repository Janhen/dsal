package com.janhen.structures.stack.BaseArray;

import com.janhen.structures.array.dynamic.Array;
import com.janhen.structures.stack.IStack;

public class Stack<E> implements IStack<E> {

    private Array<E> arr;

    public Stack(int capacity) {
        arr = new Array<>(capacity);
    }

    public Stack() {
        arr = new Array<>();
    }

    public void push(E item) {
        arr.addLast(item);
    }

    public E pop() {
        return arr.removeLast();
    }

    public E peek() {
        return arr.getLast();
    }

    public int size() {
        return arr.size();
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMinStack : size = ").append(size());
        sb.append("\n[");
        for (int i = 0;i < arr.size(); i++) {
            sb.append(i == arr.size() - 1 ? arr.get(i) : arr.get(i) + ", ");
        }
        sb.append("] top");
        return sb.toString();
    }

    private static final int DEFAULT_CAPACITY = 10;
}
