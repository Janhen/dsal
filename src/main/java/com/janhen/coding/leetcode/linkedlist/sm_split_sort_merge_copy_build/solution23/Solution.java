package com.janhen.coding.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution23;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (l1, l2)->l1.val-l2.val);   // list like each data flow
        for (ListNode list : lists)     // load all data flow
            if (list != null)
               pq.offer(list);

        ListNode first = new ListNode(-1);     // use for join together
        ListNode tail = first;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;            // sort node
            if (tail.next != null) pq.offer(tail.next);      // iterate list next element , load next node if have in this data flow
        }
        return first.next;
    }
}