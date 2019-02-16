package com.janhen.structures.queue.BaseLinkedList;

import com.janhen.structures.queue.IQueue;

public class Queue<E> implements IQueue<E> {

    // list with tail node
    private Node head;
    private Node tail;
    private int N;

    public Queue() {
        head = null;
        tail = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // "rpush + lpop"   need init
    public void enqueue(E e) {
        Node node = new Node(e);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        N ++;
    }

    // P1:0
    // P2:1
    // P3:..
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException();
        Node oldHead = head;
        head = head.next;
        oldHead.next = null;
        if (head == null)   // only one node
            tail = null;
        N --;
        return oldHead.val;
    }

    public E peek() {
        if (isEmpty())
            throw new IllegalArgumentException();
        return head.val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue : size = %d ", size()));
        sb.append("front ");

        Node cur = head;
        while (cur != tail) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append(cur.val).append(" tail");
        return sb.toString();
    }

    private class Node {
        public Node next;
        public E               val;

        public Node(E e, Node next) {
            this.val = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }
    }
}
