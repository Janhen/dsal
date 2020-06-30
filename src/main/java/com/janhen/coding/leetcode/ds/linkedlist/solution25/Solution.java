package com.janhen.coding.leetcode.ds.linkedlist.solution25;

import com.janhen.coding.leetcode.structures.ListNode;

// todo ListNode
/*
time: O(N), space: O(1)

 可以递归操作, 有两种情况：
 1. 就是压根没有k个node，那么我们直接保持这个k-group不动返回head
 2. 如果有k个node的话，那么我们先找到第k个node之后的递归结果 node = nxt，然后反转前面k个node，让反转结果的结尾 tail.next = nxt
*/
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k == 1)
      return head;

    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode begin = first;

    int i = 0;
    while (head != null) {
      i++;
      if (i % k == 0) {
        begin = reverse(begin, head.next);
        head = begin.next;
      } else {
        head = head.next;
      }
    }
    return first.next;

  }

  public ListNode reverse(ListNode begin, ListNode end) {
    ListNode cur = begin.next;
    ListNode next, first;
    ListNode prev = begin;
    first = cur;
    while (cur != end) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    begin.next = prev;
    first.next = cur;
    return first;
  }
}