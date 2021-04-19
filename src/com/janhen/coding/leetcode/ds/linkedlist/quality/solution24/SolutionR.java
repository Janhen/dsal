package com.janhen.coding.leetcode.ds.linkedlist.quality.solution24;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionR {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}