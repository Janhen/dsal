package com.janhen.coding.leetcode.ds.linkedlist.operate.solution23;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  // Like from many data stream collect data, and then find top
  public ListNode mergeKLists(ListNode[] lists) {
    // 1. load all data stream first element to heap
    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(l -> l.val));   // list like each data flow
    for (ListNode list : lists) {
      if (list != null) {
        pq.offer(list);
      }
    }

    // 2. iterate heap to continue to find next sorted element
    ListNode first = new ListNode(-1);     // use for join together
    ListNode cur = first;
    while (!pq.isEmpty()) {
      cur.next = pq.poll();
      cur = cur.next;             // sort node
      if (cur.next != null) {
        pq.offer(cur.next);       // iterate list next element , load next node if have in this data flow
      }
    }
    return first.next;
  }
}