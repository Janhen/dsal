package com.janhen.coding.leetcode.ds.linkedlist.operate.solution2;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
  }

  private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) {
      return null;
    }
    int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
    carry = val / 10;
    val = val % 10;
    ListNode head = new ListNode(val);
    head.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
    return head;
  }
}