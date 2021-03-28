package com.janhen.coding.leetcode.ds.linkedlist.quality.solution61;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution$ {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    // 1. init necessary value and refresh input
    int len = length(head);
    k = k % len;                        // preHandle
    if (k == 0) {
      return head;
    }

    // 2. find (len-k)th previous node
    // n1 -> n2 -> .... -> nk -> nk+1 -> ... -> tail -> NULL
    ListNode pre = null;  // recode len-k node
    ListNode cur = head;  // iterate and finally recode tail node
    int cnt = 0;
    while (cur.next != null) {
      cnt++;
      if (cnt == len - k) {
        pre = cur;
      }
      cur = cur.next;
    }

    // 3. unlink and link to result list node
    ListNode newHead = pre.next;        // as head
    cur.next = head;
    pre.next = null;                    // as tail
    return newHead;
  }

  private int length(ListNode head) {
    ListNode cur = head;
    int len = 0;
    while (cur != null) {
      len++;
      cur = cur.next;
    }
    return len;
  }
}