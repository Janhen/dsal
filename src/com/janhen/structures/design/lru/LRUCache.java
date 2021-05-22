package com.janhen.structures.design.lru;

import java.util.HashMap;

class LRUCache {
    // value -> node
    private final HashMap<Integer, Node> cache;
    private final int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity * 4 / 3);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        // remove from linkedList
        remove(node);
        // make node as linkedList head
        setHead(node);
        return node.val;
    }

    // region operator
    public void put(int key, int value) {
        // already have current value
        if (cache.containsKey(key)) {
            // update old value
            Node oldNode = cache.get(key);
            oldNode.val = value;
            // make node as head
            remove(oldNode);
            setHead(oldNode);
        } else {
            // make current value as head node
            Node newNode = new Node(key, value);
            // capacity limit, remove old tail
            if (cache.size() >= capacity) {
                System.out.println("Cache is FULL! Removing " + tail.val + " from cache...");
                cache.remove(tail.key);
                remove(tail);
            }
            setHead(newNode);
            cache.put(key, newNode);
        }
    }

    // remove from list node, note head tail edge
    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            // remove node is head node
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            // remove node is tail node
            tail = node.prev;
        }
    }

    // make node(newNode or accessed node) to head
    private void setHead(Node node) {
        node.next = head;
        node.prev = null;

        // init or remove no element
        if (head != null) {
            head.prev = node;
        }
        head = node;

        // init or remove no element
        if (tail == null) {
            tail = head;
        }
    }
    // endregion

    private class Node {
        Node prev;
        Node next;
        Integer key;
        Integer val;

        public Node(Integer k, Integer v) {
            this.key = k;
            this.val = v;
        }
    }
}