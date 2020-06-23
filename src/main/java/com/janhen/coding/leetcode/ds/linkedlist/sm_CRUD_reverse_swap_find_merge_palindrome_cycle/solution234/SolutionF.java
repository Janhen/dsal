package com.janhen.coding.leetcode.ds.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution234;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionF {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head, pre = null;    // record slow previous node
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;                // cut
        if (fast != null) slow = slow.next;

        ListNode l1 = head;
        ListNode l2 = reverse(slow);
        return isEqual(l1, l2);
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    private ListNode reverse(ListNode list) {
        ListNode pre = null;
        ListNode next = null;
        while (list != null) {
            next = list.next;
            list.next = pre;
            pre = list;
            list = next;
        }
        return pre;
    }
}