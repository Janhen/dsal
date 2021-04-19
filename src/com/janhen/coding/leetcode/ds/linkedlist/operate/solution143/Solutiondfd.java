package com.janhen.coding.leetcode.ds.linkedlist.operate.solution143;

// 143. Reorder List
// https://leetcode.com/problems/reorder-list/
//Medium  693:55

import com.janhen.coding.leetcode.structures.ListNode;

class Solutiondfd {
    // O(N) time, O(1) space in total
    void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // find the middle node: O(n)
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // cut from the middle and reverse the second half: O(n)
        ListNode head2 = slow.next;
        slow.next = null;

        fast = head2.next;
        head2.next = null;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = head2;
            head2 = fast;
            fast = next;
        }

        // merge two lists: O(n)
        for (slow = head, fast = head2; slow != null; ) {
            ListNode t = slow.next;
            slow = slow.next = fast;
            fast = t;
        }
    }
}