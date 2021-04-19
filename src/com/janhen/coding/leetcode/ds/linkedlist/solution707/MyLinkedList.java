package com.janhen.coding.leetcode.ds.linkedlist.solution707;

/**
 * {@link com.janhen.structures.linkedlist.LinkedList}
 */
public class MyLinkedList {

    private final Node first;
    private int N;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        first = new Node(0);
        N = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= N) return -1;

        Node cur = first.next;
        while (index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be
     * the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(N, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
     * not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > N) return;
        if (index < 0) index = 0;

        Node prev = first;
        while (index-- > 0) {
            prev = prev.next;
        }
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        N++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= N) return;

        Node prev = first;
        while (index-- > 0) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        N--;
    }

    private class Node {
        Integer val;
        Node next;

        public Node(Integer val) {
            this.val = val;
        }

        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
