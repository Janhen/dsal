package com.janhen.coding.leetcode.ds.linkedlist.sm_split_sort_merge_copy_build.solution138;

public class Node {
  public int val;
  public Node next;
  public Node random;

  public Node() {
  }

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }

  public Node(int _val, Node _next, Node _random) {
    val = _val;
    next = _next;
    random = _random;
  }
};