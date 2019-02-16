package com.janhen.structures.array.dynamic;

import com.janhen.structures.array.IArray;

public class Array<E> implements IArray<E> {

    private E[] data;

    private int N;

    private final static int DEFAULT_SIZE = 10;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        N = 0;
    }

    public Array() {
        this(DEFAULT_SIZE);
    }

    public int size() {
        return N;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void add(E val) {
        add(N, val);
    }

    public void addLast(E val) {
        add(N, val);
    }

    public void addFirst(E val) {
        add(0, val);
    }

    public void add(int index, E val) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException();
        if (N == data.length) {    // >= 2^x    every time adjust
            resize(data.length * 2);
        }

        for (int i = N - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = val;
        N ++;
    }

    // can not reuse
    private void checkSize() {
        if (N == data.length) {    // >= 2^x    every time adjust
            resize(data.length * 2);
        } else if (N == data.length / 4 && data.length != 0) {
            resize(data.length / 2);
        }
    }

    private void resize(int newCapacity) {
        E[] aux = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, aux, 0, N);
        data = aux;
    }

    public E get(int index) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException();

        return data[index];
    }

    public E getLast() {
        return get(N - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E val) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException();
        data[index] = val;
    }

    public boolean contains(E v) {
        for (E val : data) {
            if (val.equals(v))
                return true;
        }
        return false;
    }

    public int find(E v) {
        for (int i = 0; i < N; i++) {
            if (data[i].equals(v)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > N) {
            throw new IllegalArgumentException();
        }

        E ret = data[index];
        for (int i = index + 1; i < N; i++) {
            data[i - 1] = data[i];
        }
        N --;
        data[N] = null;
        if (N == data.length / 4 && data.length != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(N - 1);
    }

    public void removeElement(E v) {
        int index = find(v);
        if (index != -1)
            remove(index);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", N, data.length));
        sb.append("[");

        for (int i = 0; i < N; i++) {
            sb.append(i == N - 1 ? data[i] : data[i] + ", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
