package com.janhen.coding.leetcode.ds.linkedlist.operate.solution86;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  // 单个链表的分割
  public ListNode partition(ListNode head, int x) {
    // 1. record left part and right part list first node
    ListNode first1 = new ListNode(-1);
    ListNode first2 = new ListNode(-1);

    // 2. iteration pointer is head; continue link cur1, cur2
    // cur1(left part list), cur2(right part list) to generate two list
    ListNode cur1 = first1;
    ListNode cur2 = first2;
    while (head != null) {
      if (head.val < x) {
        cur1.next = head;
        cur1 = head;
      } else {
        cur2.next = head;
        cur2 = head;
      }
      head = head.next;
    }
    cur2.next = null;
    cur1.next = first2.next;
    return first1.next;
  }
}