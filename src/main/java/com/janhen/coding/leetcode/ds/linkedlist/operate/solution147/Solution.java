package com.janhen.coding.leetcode.ds.linkedlist.operate.solution147;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode first = new ListNode(0);
    ListNode cur = head; //the node will be inserted
    ListNode pre = first; //insert node between pre and pre.next
    ListNode next = null; //the next node will be inserted
    while (cur != null) {
      next = cur.next;
      //find the right place to insert
      while (pre.next != null && pre.next.val < cur.val) {
        pre = pre.next;
      }
      //insert between pre and pre.next
      cur.next = pre.next;
      pre.next = cur;
      pre = first;
      cur = next;
    }

    return first.next;
  }
}