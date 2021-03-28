package com.janhen.coding.leetcode.ds.linkedlist.quality.solution203;

import com.janhen.coding.leetcode.structures.ListNode;

public class SolutionRRef {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        if (head.val == val) return head.next;
        return head;
    }
}
