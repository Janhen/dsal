package com.janhen.leetcode.top100.other.solution146;

import java.util.HashMap;

// 66 ms, faster than 99.99%
public class LRUCache1 {

    class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    class LinkedDeque {
        Node head;
        Node tail;

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

        public void moveToTail(Node node) {
            if (node == tail)
                return ;
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

        // return old head
        public Node removeHead() {
            if (head == null)
                return null;
            Node oldHead = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
                oldHead.next = null;
            }
            return oldHead;
        }
    }

    private LinkedDeque linkedDeque;
    private HashMap<Integer, Node> dataMap;
    private HashMap<Node, Integer> nodeMap;
    private int capacity;

    public LRUCache1(int capacity) {
        linkedDeque = new LinkedDeque();
        dataMap = new HashMap<>();
        nodeMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (dataMap.containsKey(key)) {
            Node valNode = dataMap.get(key);
            linkedDeque.moveToTail(valNode);
            return valNode.val;
        }
        return -1;
    }

    // P1: update
    // P2: new one
    public void put(int key, int value) {
        if (dataMap.containsKey(key)) {
            Node valNode = dataMap.get(key);
            valNode.val = value;
            linkedDeque.moveToTail(valNode);
        } else {
            Node valNode = new Node(value);
            dataMap.put(key, valNode);
            nodeMap.put(valNode, key);
            linkedDeque.addNodeToTail(valNode);
            modifyIfNecessary();
        }

    }

    private void modifyIfNecessary() {
        if (dataMap.size() == capacity + 1) {
            Node oldHeadNode = linkedDeque.removeHead();
            Integer oldHeadKey = nodeMap.get(oldHeadNode);
            dataMap.remove(oldHeadKey);
            nodeMap.remove(oldHeadNode);
        }
    }
}
