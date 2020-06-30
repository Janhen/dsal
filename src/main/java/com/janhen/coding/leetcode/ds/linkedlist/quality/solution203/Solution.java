package com.janhen.coding.leetcode.ds.linkedlist.quality.solution203;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  public static ListNode removeElements(ListNode head, int val) {
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode pre = first;
    while (pre.next != null) {
      if (pre.next.val == val)
        pre.next = pre.next.next;     // val is excepted
      else
        pre = pre.next;
    }
    return first.next;
  }
}
