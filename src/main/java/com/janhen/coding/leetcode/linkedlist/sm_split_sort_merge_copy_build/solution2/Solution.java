package com.janhen.coding.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution2;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    // from left to right == from slow bit to high bit
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;

        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        ListNode head = new ListNode(val % 10);        // insure one element

        head.next = addTwoNumbers(l1 == null ? null : l1.next,
                l2 == null ? null : l2.next,
          val / 10);
        return head;
    }
}