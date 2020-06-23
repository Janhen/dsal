package com.janhen.coding.leetcode.ds.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution61;

import com.janhen.coding.leetcode.structures.ListNode;

// 7 ms, faster than 97.84%
class Solution {
    // find pre AND tail
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int len = length(head);
        k = k % len;                        // preHandle
        if (k == 0)
            return head;

        // n1 -> n2 -> .... -> nk -> nk+1 -> ... -> tail -> NULL
        // recode len-k node
        ListNode pre = null;
        ListNode cur = head;
        int cnt = 0;
        while (cur.next != null) {    // find pre node nthNodeFromEnd AND tail node
            cnt ++;
            if (cnt == len - k)       // count to calculate pre
                pre = cur;
            cur = cur.next;
        }
        ListNode newHead = pre.next;        // as head
        cur.next = head;
        pre.next = null;                  // as tail
        return newHead;
    }

    private int length(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        return len;
    }
}