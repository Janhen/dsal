package com.janhen.design.lru;

import java.util.HashMap;

// leetcode-146
public class LRUCache {

    static class Node {
        Integer key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 封装访问节点的所有操作
     */
    static class LinkedDeque {
        Node head;
        Node tail;

        // put is new one
        public void addNodeToTail(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        // access
        public void moveNodeToTail(Node node) {
            if (node == tail)
                return;
            if (node == head) {
                head = head.next;
                node.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            tail.next = node;
            node.prev = tail;
            node.next = null;  // as tail
            tail = node;
        }

        // capacity limit AND use for map delete
        public Node removeHead() {
            Node oldHead = head;
            if (head == null)
                return oldHead;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;   // as head
                oldHead.next = null;
            }
            return oldHead;
        }
    }

    /** 用于维护访问的顺序. */
    private LinkedDeque linkedDeque;
    /** 用于快速获得 key 对应的节点. */
    private HashMap<Integer, Node> keyNodeMap;
    private int capacity;

    public LRUCache(int capacity) {
        linkedDeque = new LinkedDeque();
        keyNodeMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyNodeMap.containsKey(key)) {            // not hit the cache
            Node valNode = keyNodeMap.get(key);
            linkedDeque.moveNodeToTail(valNode);
            return valNode.val;
        }
        return -1;
    }

    // update OR add one
    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            Node valNode = keyNodeMap.get(key);
            valNode.val = value;
            linkedDeque.moveNodeToTail(valNode);     // like access
        } else {
            Node valNode = new Node(key, value);
            keyNodeMap.put(key, valNode);             // linkedList + hashTable
            linkedDeque.addNodeToTail(valNode);
            modifyIfNecessary();
        }
    }

    private void modifyIfNecessary() {
        if (keyNodeMap.size() == capacity + 1) {
            Node oldHead = linkedDeque.removeHead();
            keyNodeMap.remove(oldHead.key);
        }
    }
}
