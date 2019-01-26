package com.janhen.structures.array.BaseInt;

public class Array {
    private int[] data;

    private int N;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = new int[capacity];
        N = 0;
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

    public void add(int val) {
        checkSize();
        data[N] = val;
        N ++;
    }

    public void addLast(int val) {
        add(N, val);
    }

    public void addFirst(int val) {
        add(0, val);
    }

    // any position to add element
    public void add(int index, int val) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException("input index out of range.");
        checkSize();

        // [index ... N-1]  ⇒  [index+1 ... N]
        for (int i = N - 1; i >= index; i --)
            data[i + 1] = data[i];

        data[index] = val;  // assign override to update
        N ++;
    }


    public int get(int index) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException();

        return data[index];
    }

    public void set(int index, int val) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException();
        data[index] = val;
    }


    public boolean contains(int v) {
        for (int val : data)
            if (val == v)
                return true;

        return false;
    }

    // indexOf(val)
    public int find(int v) {
        for (int i = 0; i < N; i++)
            if (data[i] == v)
                return i;

        return -1;
    }

    // remove any position
    public int remove(int index) {
        if (index < 0 || index > N) {
            throw new IllegalArgumentException();
        }

        int ret = data[index];
        // [index ... N-2] ← [index+1 ... N-1]
        for (int i = index + 1; i < N; i++)
            data[i - 1] = data[i];

        // reference to null for gc
        data[N - 1] = 0;
        N --;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(N - 1);
    }

    // find element position and reuse remove(index)
    public void removeElement(int v) {
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

    private void checkSize() {
        if (N >= data.length) {
            grow();
        }
    }

    private void grow() {
    }
}
