package main.java.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution143;

// 143. Reorder List
// https://leetcode.com/problems/reorder-list/
//Medium  693:55

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

import main.java.janhen.leetcode.structures.ListNode;

class Solutiondfd {
    // O(N) time, O(1) space in total
    void reorderList(ListNode head) {
        if (head == null|| head.next == null) return;

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