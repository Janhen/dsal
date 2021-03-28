package com.janhen.coding.leetcode.ds.linkedlist.solution1171;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public ListNode removeZeroSumSublists(ListNode head) {
    // pre check
    if (head == null || (head.next == null && head.val == 0)) {
      return null;
    }
    if (head.next == null) {
      return head;
    }

    ListNode first = new ListNode(0);
    first.next = head;
    // sum -> node, 存放当前和最后一次的节点
    Map<Integer, ListNode> sumNodeMap = new HashMap<>();
    int curSum = 0;
    ListNode cur = first;  // TOWHY
    while (cur != null) {
      curSum += cur.val;
      sumNodeMap.put(curSum, cur);
      cur = cur.next;
    }

    // 从链表中删除连续的 0
    curSum = 0;
    cur = first;
    while (cur != null) {
      curSum += cur.val;
      cur.next = sumNodeMap.get(curSum).next;
      cur = cur.next;
    }
    return first.next;
  }
}