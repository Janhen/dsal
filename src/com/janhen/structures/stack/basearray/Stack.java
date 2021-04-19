package com.janhen.structures.stack.basearray;

import com.janhen.structures.stack.IStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements IStack<E>, Iterable<E> {
    private E[] arr = (E[]) new Object[2];
    private int N;

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void push(E item) {
        if (N == arr.length) {
            resize(2 * arr.length);
        }
        arr[N] = item;
        N++;
    }

    // "rpush + rpop"
    @Override
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();

        E oldTop = arr[N - 1];
        arr[N - 1] = null;
        N--;
        if (N == arr.length / 4 && arr.length != 0)
            resize(arr.length / 2);
        return oldTop;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException();

        return arr[N - 1];
    }

    private void resize(int capacity) {
        E[] aux = (E[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            aux[i] = arr[i];
        }
        arr = aux;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Stack : size = %d, capacity=%d\n", N, arr.length));
        sb.append("[");
        for (int i = 0; i < N; i++) {
            sb.append(i != N - 1 ? arr[i] + ", " : arr[i]);
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    // stack traversal and not modify element
    private class ReverseArrayIterator implements Iterator<E> {
        int i = N - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return arr[i--];
        }
    }
}
