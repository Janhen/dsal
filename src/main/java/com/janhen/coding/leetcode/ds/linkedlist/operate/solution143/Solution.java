package com.janhen.coding.leetcode.ds.linkedlist.operate.solution143;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    // 1. find mid node
    ListNode preMid = preMidNode(head);

    // 2. cut and reverse right half list node
    ListNode l1 = head;
    ListNode l2 = reverse(preMid.next); // NOTE: may more than l1 one element
    preMid.next = null;                 // cut into two list

    // 3. merge cross in condition
    mergeCross(l1, l2);
  }

  /**
   * 交叉合并链表
   *
   * @param l1
   * @param l2
   * @return 合并后的链表
   */
  public static ListNode mergeCross(ListNode l1, ListNode l2) {
    ListNode newHead = l1;
    ListNode next1 = null;
    ListNode next2 = null;  // record original next node
    // l1, l2 as iteration pointer
    while (l1 != null && l2 != null) {
      // l1 -> n1 -> xx    =>   l1 -> l2 -> n1 -> xx
      // l2 -> n2 -> yy    =>   n2 -> yy
      next1 = l1.next;
      next2 = l2.next;
      l1.next = l2;                               // adjust four pointer to meet condition order
      if (next1 == null) {
        break;
      }
      l2.next = next1;
      if (next2 == null) {
        break;
      }
      l1 = next1;
      l2 = next2;
    }
    return newHead;
  }

  private ListNode preMidNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode pre = null;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    return pre;
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