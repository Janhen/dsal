package com.janhen.structures.queue.BaseLoopArray2;

public class Queue {
    private Integer[] arr;
    private Integer   N;
    private Integer   first;
    private Integer   last;     // point to add element

    public Queue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        N = 0;
        first = 0;
        last = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return last == first;
    }

    public Integer peek() {
        if (N == 0) {
            return null;
        }
        return arr[first];
    }

    // maintain: last, N
    public void enqueue(int obj) {
        if (N == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        N++;
        arr[last] = obj;
        last = last == arr.length - 1 ? 0 : last + 1;
    }

    // maintain: first, N
    public Integer dequeue() {
        if (N == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        N--;
        int tmp = first;
        first = first == arr.length - 1 ? 0 : first + 1;
        return arr[tmp];
    }
}
