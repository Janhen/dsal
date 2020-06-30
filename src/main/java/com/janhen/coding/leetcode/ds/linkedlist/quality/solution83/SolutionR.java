package com.janhen.coding.leetcode.ds.linkedlist.quality.solution83;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionR {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode next = head.next;
    if (head.val == head.next.val) {
      while (next.next != null && head.val == next.next.val)
        next = next.next;   // next is last excepted
      return deleteDuplicates(next);
    } else {
      head.next = deleteDuplicates(next);
      return head;
    }
  }
}