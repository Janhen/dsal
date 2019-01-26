package com.janhen.structures.stack.BaseArr;

import com.janhen.structures.stack.IStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<E> implements IStack<E>, Iterable<E> {
    private E[] arr = (E[]) new Object[2];
    private int N;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(E item) {
        ensureCapacity();

        arr[N] = item;
        N ++;
    }

    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();

        // N - 1: current last element
        E oldTop = arr[N - 1];
        arr[N - 1] = null;
        N  --;

        ensureCapacity();
        return oldTop;
    }

    public E peek() {
        if (isEmpty()) throw new NoSuchElementException();

        return arr[N - 1];
    }

    private void ensureCapacity() {
        if (N == arr.length) {
            resize(N > 64 ? arr.length * 2 : (int) (arr.length * 1.5));
        } else if (N > 0 && N == arr.length / 4) {
            //Oscillation of complexity
            resize(arr.length / 2);
        }
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
        for (int i = 0;i < N; i++) {
            sb.append(arr[i]).append(", ");
        }
        // must have one
        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }


    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E> {
        int i = N - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return arr[i --];
        }
    }
}
