package com.janhen.coding.leetcode.ds.linkedlist.solution430;

class Node {
  public int val;
  public Node prev;
  public Node next;
  public Node child;

  public Node(int val, Node prev, Node next, Node child) {
    this.val = val;
    this.prev = prev;
    this.next = next;
    this.child = child;
  }
}

public class Solution {
  public Node flatten(Node head) {
    if (head == null) return head;
    Node first = new Node(0, null, head, null);
    dfs(first, head);
    first.next.prev = null;
    return first.next;
  }

  /* return the tail of the flatten list */
  // pre-order traverse
  public Node dfs(Node prev, Node curr) {
    if (curr == null)
      return prev;
    curr.prev = prev;
    prev.next = curr;

    Node tmpNext = curr.next;
    // child to iterate
    Node tail = dfs(curr, curr.child);
    curr.child = null;
    // original next to iterate
    return dfs(tail, tmpNext);
  }
}
