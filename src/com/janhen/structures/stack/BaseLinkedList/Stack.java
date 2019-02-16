package com.janhen.structures.stack.BaseLinkedList;

import com.janhen.structures.LinkedList.dummyHead.LinkedList;
import com.janhen.structures.stack.IStack;

public class Stack<E> implements IStack<E> {

    private LinkedList<E> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    // lpush + lpop
    public void push(E e) {
        list.addFirst(e);
    }

    public E pop() {
        return list.removeFirst();
    }

    public E peek() {
        return list.getFirst();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: top ");
        sb.append(list);
        return sb.toString();
    }
}
