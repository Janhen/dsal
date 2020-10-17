package com.janhen.coding.leetcode.ds.linkedlist.quality.solution206;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}