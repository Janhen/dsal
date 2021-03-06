package com.janhen.coding.leetcode.ds.linkedlist.operate.solution148;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. find mid node and cut two list
        ListNode preMid = preMidNode(head);
        ListNode mid = preMid.next;
        preMid.next = null;
        // 2. handle two sub problem
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        // 3. merge result
        return merge(l1, l2);
    }

    private ListNode preMidNode(ListNode head) {
        ListNode pre = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}