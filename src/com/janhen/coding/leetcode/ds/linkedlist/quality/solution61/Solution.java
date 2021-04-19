package com.janhen.coding.leetcode.ds.linkedlist.quality.solution61;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode slow = first;
        ListNode fast = first;    // slow point to pre,  fast point to tail

        // find all list count
        int N = 0;
        while (fast.next != null) {
            N++;
            fast = fast.next;
        }

        // make slow move to
        int step = N - k % N;   // need to step from dummy
        while (step-- > 0) {
            slow = slow.next;
        }

        // split and join
        fast.next = first.next;
        first.next = slow.next;
        slow.next = null;
        return first.next;
    }
}