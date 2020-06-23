package com.janhen.coding.leetcode.ds.linkedlist.sm_split_sort_merge_copy_build.solution143;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode preMid = findPreMidNode(head);
        ListNode l1 = head;
        ListNode l2 = reverse(preMid.next);           // NOTE: may more than l1 one element
        preMid.next = null;           // cut into two list

        mergeCross(l1, l2);
    }

    public static ListNode mergeCross(ListNode l1, ListNode l2) {
        ListNode newHead = l1;
        // l1, l2 as iteration pointer
        while (l1 != null && l2 != null) {
            // record original next node
            ListNode next1 = l1.next, next2 = l2.next;
            // adjust four pointer to meet condition order
            l1.next = l2;
            if (next1 == null) break;
            l2.next = next1;
            if (next2 == null) break;
            l1 = next1;
            l2 = next2;
        }
        return newHead;
    }

    private ListNode findPreMidNode(ListNode head) {
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}