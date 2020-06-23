package com.janhen.coding.leetcode.ds.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution203;

import com.janhen.coding.leetcode.structures.ListNode;

public class SolutionRef {

    // need handle head is deleted node
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)  // find first not val node
            head = head.next;
        if (head == null)
            return null;
        ListNode pre = head;
        while (pre != null && pre.next != null) {
            if (pre.next.val == val) pre.next = pre.next.next;
            else pre = pre.next;
        }
        return head;
    }
}
