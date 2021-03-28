package com.janhen.coding.leetcode.ds.linkedlist.quality.solution83;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = head;
    while (pre.next != null) {
      if (pre.val == pre.next.val) {    // can save pre
        ListNode cur = pre.next;
        while (cur.next != null && pre.val == cur.next.val) { // find last duplication
          cur = cur.next;
        }
        pre.next = cur.next;
      } else {
        pre = pre.next;
      }
    }
    return head;
  }
}