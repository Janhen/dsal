package com.janhen.coding.leetcode.ds.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution82;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {    // pre.next.val is expected
                ListNode cur = pre.next;
                while (cur.next != null && cur.val == cur.next.val)    // find last duplication
                    cur = cur.next;
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
        }
        return first.next;
    }
}