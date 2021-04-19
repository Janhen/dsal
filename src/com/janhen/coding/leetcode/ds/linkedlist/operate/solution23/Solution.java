package com.janhen.coding.leetcode.ds.linkedlist.operate.solution23;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    // Like from many data stream collect data, and then find top
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 初始化加载所有链表的头节点
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(l -> l.val));   //
        // list like each data flow
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // 比较每条链表当前的头节点
        ListNode first = new ListNode(-1);
        ListNode cur = first;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return first.next;
    }
}