package com.janhen.coding.leetcode.ds.linkedlist.quality.solution19;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  // dummy node + fast slow pointer
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // 1. iteration to find nth node
    ListNode fast = head;
    while (n-- > 0)
      fast = fast.next;
    // 2. dummy node to record previous node
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode pre = first;
    // 3. find nthFromEnd previous node
    while (fast != null) {
      pre = pre.next;
      fast = fast.next;
    }
    // 4. unlink list node
    pre.next = pre.next.next;
    return first.next;
  }
}