package com.janhen.coding.leetcode.ds.linkedlist.quality.solution83;

// 83. Remove Duplicates from Sorted List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// Easy  634:69

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionRRef {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val)
            return head.next;
        else
            return head;
    }
}