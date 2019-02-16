package com.janhen.structures.LinkedList.dummyHead;

import com.janhen.structures.LinkedList.ILinkedList;

import java.util.List;

public class LinkedList<E> implements ILinkedList<E> {

    private Node first;
    private int  N;

    public LinkedList() {
        first = new Node(null, null);
        N = 0;
    }

    public LinkedList(List<E> list) {
        first = new Node(null, null);
        N = 0;
        for (E val : list) {
            addLast(val);
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(E key) {
        Node cur = first.next;
        while (cur != null) {
            if (cur.val.equals(key))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public void add(int index, E e) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException();

        Node prev = first;   // walk forward index step  ⇔  [index-1]
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        // prev.next = new Node(e, prev);
        N ++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(N, e);
    }

    public E get(int index) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException();

        Node cur = first.next;
        for (int i = 0; i < index; i ++)
            cur = cur.next;
        return cur.val;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size() - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException();

        Node cur = first.next;
        for (int i = 0; i < index; i ++)
            cur = cur.next;
        cur.val = e;
    }

    public E remove(int index) {
        if (index < 0 || index > N)
            throw new IllegalArgumentException();

        Node prev = first;
        for (int i = 0; i < index; i ++)
            prev = prev.next;

        Node delNode = prev.next;
        prev.next = delNode.next;

        // not need save
        // E val = delNode.val;
        delNode.next = null;
        N--;
        return delNode.val;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(N - 1);
    }

    public void remove(Node node) {

    }

    public void removeElement(E key) {
        Node cur = first.next;
        Node prev = first;
        while (cur != null) {
            Node next = cur.next;
            if (cur.val.equals(key)) {
                prev.next = next;
                cur.next = null;  // eliminate unnessary reference
                break;
            }
            prev = cur;
            cur = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = first.next;
        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    private class Node {
        public Node next;
        public E    val;

        public Node(E e, Node next) {
            this.val = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }
}
