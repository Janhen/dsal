package com.janhen.coding.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution148;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        return merge(l1, l2);
    }

    private ListNode preMid(ListNode head) {
        ListNode pre = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}