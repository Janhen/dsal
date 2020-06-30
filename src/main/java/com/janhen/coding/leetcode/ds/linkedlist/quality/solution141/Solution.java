package com.janhen.coding.leetcode.ds.linkedlist.quality.solution141;

import com.janhen.coding.leetcode.structures.ListNode;

public class Solution {
  public boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast)
        return true;
    }
    return false;
  }
}