package com.janhen.coding.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution2;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionRef {
    private int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && carry == 0)    // terminal
            return null;
        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;   // handle one null condition OR all null condition
        carry = val / 10;
        ListNode head = new ListNode(val % 10);
        head.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        return head;
    }
}