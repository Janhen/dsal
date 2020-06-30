package com.janhen.coding.leetcode.ds.linkedlist.operate.solution147;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionRef {
  // todo https://leetcode.com/problems/insertion-sort-list/discuss/46420/An-easy-and-clear-way-to-sort-(-O(1)-space-)
  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode helper = new ListNode(0); //new starter of the sorted list
    ListNode cur = head; //the node will be inserted
    ListNode pre = helper; //insert node between pre and pre.next
    ListNode next = null; //the next node will be inserted
    //not the end of input list
    while (cur != null) {
      next = cur.next;
      //find the right place to insert
      while (pre.next != null && pre.next.val < cur.val) {
        pre = pre.next;
      }
      //insert between pre and pre.next
      cur.next = pre.next;
      pre.next = cur;
      pre = helper;
      cur = next;
    }

    return helper.next;
  }
}