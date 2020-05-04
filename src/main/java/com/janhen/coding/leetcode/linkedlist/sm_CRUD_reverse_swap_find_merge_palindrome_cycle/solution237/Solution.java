package main.java.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution237;

import main.java.janhen.leetcode.structures.ListNode;

class Solution {
    // assign to implement: only to mid node
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }
}