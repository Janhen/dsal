package main.java.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution203;

import main.java.janhen.leetcode.structures.ListNode;

class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        while (pre.next != null) {
            if (pre.next.val == val)
                pre.next = pre.next.next;     // val is excepted
            else
                pre = pre.next;
        }
        return first.next;
    }
}
