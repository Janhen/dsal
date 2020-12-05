package com.janhen.coding.leetcode.ds.linkedlist.quality.solution234;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionF {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode preMid = preMid(head);
    return isEqual(head, reverse(preMid.next));
  }

  private ListNode preMid(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode pre = null;    // record slow previous node
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    return pre;
  }

  private boolean isEqual(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
      if (l1.val != l2.val) {
        return false;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    ListNode next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}