package com.janhen.coding.leetcode.ds.linkedlist.operate.solution328;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null)
      return null;

    ListNode cur1 = head, cur2 = head.next; // odd, even to iterate list,
    ListNode evenHead = cur2;               // evenHead to record even list head
    while (cur1.next != null && cur2.next != null) {          // even is fast than odd one step ⇔ odd.next != null && even.next != null
      cur1.next = cur1.next.next;
      cur1 = cur1.next;
      cur2.next = cur2.next.next;
      cur2 = cur2.next;
    }
    cur1.next = evenHead;
    return head;
  }
}
