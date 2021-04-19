package com.janhen.coding.leetcode.ds.linkedlist.quality.solution203;

import com.janhen.coding.leetcode.structures.ListNode;

public class SolutionR {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            return removeElements(head.next, val);    // like traverse
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
