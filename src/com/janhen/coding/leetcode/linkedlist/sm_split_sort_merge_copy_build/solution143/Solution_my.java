package com.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution143;

import com.janhen.leetcode.structures.ListNode;

class Solution_my {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode preMid = preMid(head);
        ListNode l1 = head;
        ListNode l2 = reverse(preMid.next);           // NOTE: may more than l1 one element
        preMid.next = null;           // cut into two list

        mergeCross(l1, l2);
    }

    public static ListNode mergeCross(ListNode l1, ListNode l2) {
        ListNode newHead = l1;
        while (l1 != null && l2 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;
            if (n2 == null) break;
            l1 = n1;
            l2 = n2;
        }
        return newHead;
    }

    private ListNode preMid(ListNode head) {
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