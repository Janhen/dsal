package com.janhen.coding.leetcode.ds.linkedlist.quality.solution83;

// 83. Remove Duplicates from Sorted List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// Easy  634:69

import com.janhen.coding.leetcode.structures.ListNode;

class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;             // must can save head
        ListNode cur = pre.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                while (cur != null && pre.val == cur.val)        // find first not duplication
                    cur = cur.next;
                if (cur == null) {
                    pre.next = null;
                    break;
                }
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}