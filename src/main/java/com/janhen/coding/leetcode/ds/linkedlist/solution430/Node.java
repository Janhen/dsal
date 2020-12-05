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
