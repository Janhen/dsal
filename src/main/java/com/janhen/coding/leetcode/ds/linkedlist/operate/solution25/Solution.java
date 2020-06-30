package com.janhen.coding.leetcode.ds.linkedlist.operate.solution25;

import com.janhen.coding.leetcode.structures.ListNode;

/*
time: O(N), space: O(1)

 可以递归操作, 有两种情况：
 1. 就是压根没有k个node，那么我们直接保持这个k-group不动返回head
 2. 如果有k个node的话，那么我们先找到第k个node之后的递归结果 node = nxt，然后反转前面k个node，让反转结果的结尾 tail.next = nxt
*/
class Solution {
  // todo ListNode
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k == 1)
      return head;

    // 1. dummy head to record head
    ListNode first = new ListNode(-1);
    first.next = head;
    ListNode begin = first;

    // 2. use head to iterate and i record index
    int idx = 0;
    while (head != null) {
      idx++;
      // 3. collect result and reset begin
      if (idx % k == 0) {
        begin = reverse(begin, head.next);
        head = begin.next;
      } else {
        head = head.next;
      }
    }
    // 4. return real head
    return first.next;
  }

  // @return:
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