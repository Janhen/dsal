package com.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution203;

import com.janhen.leetcode.structures.ListNode;

public class SolutionRRef {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        if (head.val == val) return head.next;
        return head;
    }
}
