package com.janhen.coding.leetcode.ds.linkedlist.sm_split_sort_merge_copy_build.solution21;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // record sorted list first node
        ListNode first = new ListNode(-1);
        // list act as a go-between
        ListNode cur = first;
        // iterate two list
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
        // handle one list is null
        if (l1 == null)
            cur.next = l2;
        if (l2 == null)
            cur.next = l1;
        return first.next;
    }
}