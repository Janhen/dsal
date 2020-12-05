package com.janhen.coding.leetcode.ds.linkedlist.quality.solution237;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  // assign to implement: only to mid node
  public void deleteNode(ListNode node) {
    if (node == null || node.next == null) {
      return;
    }
    ListNode next = node.next;
    node.val = next.val;
    node.next = next.next;
    next.next = null;
  }
}