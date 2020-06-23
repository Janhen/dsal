package com.janhen.coding.leetcode.ds.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution92;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionRef {

    //  2 ms, faster than 100.00%
    public ListNode reverseBetween(ListNode head, int from, int to) {
        ListNode fPrev = null;
        ListNode tPost = null;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len ++;
            if (len == from-1) fPrev = cur;
            if (len == to+1) tPost = cur;
            cur = cur.next;
        }
        if (from > to || from < 1 || to > len)
            return head;
        ListNode pre = fPrev == null ? head : fPrev.next;   // whether or not include head
        cur = pre.next;
        pre.next = tPost;
        ListNode next = null;
        while (cur != tPost) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (fPrev != null) {   // head not include in
            fPrev.next = pre;  // now pre is head node that reversed list
            return head;
        }
        return pre;   // old head is reversed
    }
}