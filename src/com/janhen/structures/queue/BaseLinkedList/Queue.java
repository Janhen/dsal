package com.janhen.structures.queue.baseLinkedList;

import com.janhen.structures.queue.IQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements IQueue<E>, Iterable<E> {

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

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator<E> implements Iterator<E> {
        private Node cur = head;

        public boolean hasNext()  {
            return cur != null;
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = (E) cur.val;
            cur = cur.next;
            return item;
        }
    }
}
