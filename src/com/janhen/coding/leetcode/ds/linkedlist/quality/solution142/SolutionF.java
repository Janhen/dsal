package com.janhen.coding.leetcode.ds.linkedlist.quality.solution142;

import com.janhen.coding.leetcode.structures.ListNode;

public class SolutionF {
  // x + y = x + y + n (y + z)
  // fast指针是一步走两个节点，slow指针一步走一个节点， 所以 fast指针走过的节点数 = slow指针走过的节点数 * 2
  // ==> (x + y) * 2 = x + y + n (y + z)
  // ==> x + y = n (y + z)
  // ==> x = n (y + z) -y
  // ==> x = (n - 1) * (y + z) + z     n 一定大于 1
  // ==> 从头结点出发一个指针，从相遇节点也出发一个指针，这两个指针每次只走一个节点，那么当这两个指针相遇的时候就是环形入口的节点
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        break;
      }
    }
    if (fast == null || fast.next == null) {
      return null;   // have no loop
    }
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}