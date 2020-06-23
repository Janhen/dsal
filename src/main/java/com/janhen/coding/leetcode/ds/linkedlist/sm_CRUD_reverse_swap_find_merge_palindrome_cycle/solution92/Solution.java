package com.janhen.coding.leetcode.ds.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution92;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        for(int i = 0; i<m-1; i++)
            pre = pre.next;   // find mth node previous
        // link reverse list
        pre.next = reverseCount(pre.next, n - m);
        return first.next;
    }

    private ListNode reverseCount(ListNode head, int n) {
        ListNode reversedTail = head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        for (int i = 0; i <= n; i ++) {           // Note: must <=n, because return is pre
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        reversedTail.next = next;
        return pre;
    }
}