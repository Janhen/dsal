package com.janhen.coding.leetcode.ds.linkedlist.quality.solution82;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionR {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        if (head.val == next.val) {
            while (next != null && head.val == next.val)  // head.val is excepted
                next = next.next;
            return deleteDuplicates(next);    // next is first not equal excepted value
        } else {
            head.next = deleteDuplicates(next);
            return head;
        }
    }
}