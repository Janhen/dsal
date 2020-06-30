package com.janhen.coding.leetcode.ds.linkedlist.quality.solution237;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionCor {
  // 在 O(1) 时间复杂度删除节点
  // P1: head
  // P2: middle node
  // P3: tail node
  public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
    if (head == null || tobeDelete == null)
      return null;
    if (tobeDelete.next != null) {   // not tail
      ListNode next = tobeDelete.next;
      tobeDelete.val = next.val;
      tobeDelete.next = next.next;
      next.next = null;
    } else {
      if (head == tobeDelete) {  // only one element
        head = null;
      } else {
        ListNode cur = head;
        while (cur.next != tobeDelete)      // find 2th from end
          cur = cur.next;
        cur.next = null;   // as tail
      }
    }
    return head;
  }
}