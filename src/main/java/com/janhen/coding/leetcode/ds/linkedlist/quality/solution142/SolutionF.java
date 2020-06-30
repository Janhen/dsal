package com.janhen.coding.leetcode.ds.linkedlist.quality.solution142;

import com.janhen.coding.leetcode.structures.ListNode;

public class SolutionF {
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow)
        break;
    }
    if (fast == null || fast.next == null)
      return null;   // have no loop
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}