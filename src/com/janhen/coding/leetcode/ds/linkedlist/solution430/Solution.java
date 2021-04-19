package com.janhen.coding.leetcode.ds.linkedlist.solution430;

public class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node first = new Node(0, null, head, null);
        dfs(first, head);
        first.next.prev = null;
        return first.next;
    }

    /* return the tail of the flatten list */
    // pre-order traverse
    public Node dfs(Node pre, Node cur) {
        if (cur == null) {
            return pre;
        }
        cur.prev = pre;
        pre.next = cur;

        Node next = cur.next;
        // child to iterate
        Node tail = dfs(cur, cur.child);
        cur.child = null;
        // original next to iterate
        return dfs(tail, next);
    }
}
