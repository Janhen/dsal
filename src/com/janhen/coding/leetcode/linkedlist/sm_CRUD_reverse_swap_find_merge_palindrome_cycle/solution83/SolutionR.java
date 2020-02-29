package com.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution83;

// 83. Remove Duplicates from Sorted List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// Easy  634:69

import com.janhen.leetcode.structures.ListNode;

class SolutionR {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        if (head.val == head.next.val) {
            while (next.next != null && head.val == next.next.val)
                next = next.next;   // next is last excepted
            return deleteDuplicates(next);
        }
        else {
            head.next = deleteDuplicates(next);
            return head;
        }
    }
}