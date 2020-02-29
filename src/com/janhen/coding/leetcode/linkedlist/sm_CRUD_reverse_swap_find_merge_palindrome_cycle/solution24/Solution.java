package com.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution24;

import com.janhen.leetcode.structures.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        while (pre.next != null && pre.next.next != null) {    // note : must first judge pre.next != null
            ListNode n1 = pre.next, n2 = n1.next, next = n2.next;
            n1.next = next;
            n2.next = n1;
            pre.next = n2;
            pre = n1;
        }
        return first.next;
    }
}