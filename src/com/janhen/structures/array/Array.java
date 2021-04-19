package com.janhen.structures.array;

/**
 * 动态数组
 */
public class Array<E> {

    private final static int DEFAULT_SIZE = 10;
    private E[] data;
    private int N;

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

    public boolean isEmpty() {
        return N == 0;
    }

    public int capacity() {
        return data.length;
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
            throw new IndexOutOfBoundsException();
        if (N == data.length) {    // >= 2^x    every time adjust
            resize(data.length * 2);
        }

        for (int i = N - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = val;
        N++;
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

    // find first occur index, help for remove Element
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
            throw new IndexOutOfBoundsException();
        }

        E ret = data[index];
        for (int i = index + 1; i < N; i++) {
            data[i - 1] = data[i];
        }
        data[N - 1] = null;
        N--;
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
