package com.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution83;

import com.janhen.leetcode.structures.ListNode;

class Solution_my {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.val == pre.next.val) {    // can save pre
                ListNode cur = pre.next;
                while (cur.next != null && pre.val == cur.next.val)   // find last duplication
                    cur = cur.next;
                pre.next = cur.next;
            } else  {
                pre = pre.next;
            }
        }
        return head;
    }
}