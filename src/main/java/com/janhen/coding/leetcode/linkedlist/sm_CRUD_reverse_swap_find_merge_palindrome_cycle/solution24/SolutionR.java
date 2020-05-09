package com.janhen.coding.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution24;

//24. Swap Nodes in Pairs
//        https://leetcode.com/problems/swap-nodes-in-pairs/description/

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionR {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode n = head.next;
        head.next = swapPairs(n.next);
        n.next = head;
        return n;
    }
}