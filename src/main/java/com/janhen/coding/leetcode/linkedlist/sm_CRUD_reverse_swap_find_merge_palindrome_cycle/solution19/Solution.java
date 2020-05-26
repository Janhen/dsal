package com.janhen.coding.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution19;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    // dummy node + fast slow pointer
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // iteration to find nth node
        ListNode fast = head;
        while (n -- > 0)
            fast = fast.next;

        // dummy node to record previous node
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;

        // find nthFromEnd previous node
        while (fast != null) {
            pre = pre.next;
            fast = fast.next;
        }
        pre.next = pre.next.next;
        return first.next;
    }
}