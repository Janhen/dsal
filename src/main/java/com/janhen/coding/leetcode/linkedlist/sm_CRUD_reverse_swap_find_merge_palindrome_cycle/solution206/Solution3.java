package com.janhen.coding.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution206;

//206. Reverse Linked List
//        https://leetcode.com/problems/reverse-linked-list/description/

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.Stack;


class Solution3 {

    // 借助 container to join listNode
    // when add, need eliminate reference
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // step1: truncate list AND put into container
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            stack.push(cur);
            cur = next;
        }
        // step2: reconstruct
        ListNode reverseHead = stack.pop();
        cur = reverseHead;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            cur.next = node;
            cur = node;
        }
        return reverseHead;
    }
}