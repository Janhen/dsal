package main.java.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution203;

import main.java.janhen.leetcode.structures.ListNode;

public class SolutionR {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val)
            return removeElements(head.next, val);    // like traverse
        else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
