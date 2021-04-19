package com.janhen.coding.leetcode.ds.linkedlist.operate.solution21;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1. record sorted list first node
        ListNode first = new ListNode(-1);
        // 2. iterate and store tail node
        ListNode cur = first;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        // 3. handle one list is null
        if (l1 == null)
            cur.next = l2;
        if (l2 == null)
            cur.next = l1;
        // 4. return first
        return first.next;
    }
}