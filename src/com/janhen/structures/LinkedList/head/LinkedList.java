package com.janhen.structures.LinkedList.head;


public class LinkedList<E> {

    private Node head;
    private int N;

    public LinkedList() {
        head = null;
        N = 0;
    }


    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void addLast(E e) {
        Node n = new Node(e);
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
        }
        cur.next = n;

        N--;
    }

    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;
        // head = new Node(e, head);
        N++;
    }

    public void add(int index, E e) {
        if (index < 0  || index > N)
            throw new IllegalArgumentException();

        if (index == 0) {  // head handle
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i ++) {
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            N ++;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node cur = head;
        while (cur != null) {
            sb.append(cur.next == null ? cur.val : cur.val + "->");
            cur = cur.next;
        }
        return sb.toString();
    }

    private class Node {
        public Node next;
        public E val;

        public Node(E e, Node next) {
            this.val = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            /*Node cur = next;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(val);
            while (cur != null) {
                sb.append(cur.next == null ? val : val + ", ");
                cur = cur.next;
            }
            sb.append("]");
            return sb.toString();*/
            return val.toString();
        }

    }
}
