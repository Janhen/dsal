package main.java.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution203;

import main.java.janhen.leetcode.structures.ListNode;

public class SolutionRed {

    // delete unnecessary reference to gc
    // non recursion
    // P1: delete is head node
    // P2: not head node
    public ListNode removeElements(ListNode head, int val) {
        // init handle : find first node that not equal val
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null)   // have no non head.val
            return null;

        ListNode prev = head;    // now head ⇔  first
        while (prev != null && prev.next != null) {
            if (prev.next.val == val) {
                ListNode cur = prev.next;
                prev.next = cur.next;
                cur.next = null;
            } else
                prev = prev.next;
        }
        return head;
    }

}
