package com.janhen.structures.design.lru;

import java.util.HashMap;

/**
 * 借助自定义的双端队列实现<br>
 * 控制 hit 的节点移动到队首
 */
public class LRUCache2 {
    private final LinkedDeque linkedDeque;
    private final HashMap<Integer, Node> keyNodeMap;
    private final int capacity;

    public LRUCache2(int capacity) {
        linkedDeque = new LinkedDeque();
        keyNodeMap = new HashMap<>(capacity * 4 / 3);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyNodeMap.containsKey(key)) { // hit the cache
            Node valNode = keyNodeMap.get(key);
            linkedDeque.moveNodeToTail(valNode);
            return valNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            Node valNode = keyNodeMap.get(key);
            valNode.val = value; // update
            linkedDeque.moveNodeToTail(valNode);
        } else {
            Node valNode = new Node(key, value);
            keyNodeMap.put(key, valNode);
            linkedDeque.offerLast(valNode);
            modifyIfBeyond();
        }
    }

    /**
     * capacity control
     */
    private void modifyIfBeyond() {
        if (keyNodeMap.size() == capacity + 1) {
            Node oldHead = linkedDeque.pollFirst();
            keyNodeMap.remove(oldHead.key);
        }
    }

    static class Node {
        Integer key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class LinkedDeque {
        Node head;
        Node tail;

        public void offerLast(Node node) {
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
        }

        public Node pollFirst() {
            if (head == null) { // none element
                return null;
            }

            Node oldHead = head;
            if (head == tail) { // one element
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
                oldHead.next = null;
            }
            return oldHead;
        }

        // as latest access node
        public void moveNodeToTail(Node node) {
            if (node == tail) {
                return;
            }

            // isolate node
            if (node == head) {
                head = head.next;
                node.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }
}
