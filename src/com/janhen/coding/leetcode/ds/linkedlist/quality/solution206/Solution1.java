package com.janhen.coding.leetcode.ds.linkedlist.quality.solution206;

//206. Reverse Linked List
//        https://leetcode.com/problems/reverse-linked-list/description/

import com.janhen.coding.leetcode.structures.ListNode;

class Solution1 {
  // 头插法实现
  public ListNode reverseList(ListNode head) {
    ListNode first = new ListNode(-1);  // only new, not point to head now
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = first.next;
      first.next = cur;
      cur = next;
    }
    return first.next;
  }
}