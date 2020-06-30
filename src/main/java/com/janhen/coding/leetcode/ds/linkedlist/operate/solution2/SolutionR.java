package com.janhen.coding.leetcode.ds.linkedlist.operate.solution2;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionR {
  // from left to right == from slow bit to high bit
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
  }

  private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0)
      return null;
    // 1. calculate current value and build node
    int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
    carry = val / 10;
    ListNode head = new ListNode(val % 10);        // insure one element
    // 2. recursive invoke
    head.next = addTwoNumbers(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
    return head;
  }
}