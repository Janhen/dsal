package com.janhen.structures.queue.BaseLoopArray;

import com.janhen.structures.queue.IQueue;

public class Queue<E> implements IQueue<E> {

    private E[] data;
    private int front, tail;
    private int N;

    public Queue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        N = 0;
    }

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        // ★logic can store element count
        return data.length - 1;
    }

    @Override
    public void enqueue(E item) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = item;
        tail = (tail + 1) % data.length;
        N ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalArgumentException();

        E oldV = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        N --;

        if (N == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return oldV;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalArgumentException();

        return data[front];
    }

    // ★★  [front]..[len-1]..[tail]  ⇒  [0]...[N-1]
    private void resize(int newCapacity) {
        E[] aux = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size(); i++) {
            aux[i] = data[(i + front) % data.length];  // from front to tail
        }
        data = aux;
        front = 0;
        tail = N;
    }


//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("Queue : size = %d, capacity = %d \n", size(), getCapacity()));
//        sb.append("front [");
//        // traverse from index front to tail
//        for (int i = front; i != tail; i = (i + 1) % data.length) {
//            sb.append((i + 1) % data.length == tail ? data[i] : data[i] + ", ");
//        }
//        sb.append("] tail");
//        return sb.toString();
//    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue : size = %d, capacity = %d \n", size(), getCapacity()));
        sb.append("front [");
        // traverse from index front to tail
        for (int i = 0; i < size(); i ++) {
            int curIndex = (i+front) % data.length;
            sb.append(curIndex != tail - 1 ? data[curIndex] + ", ": data[curIndex]);
        }
        sb.append("] tail");
        return sb.toString();
    }

    private static final int DEFAULT_CAPACITY = 10;
}
