package com.janhen.coding.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution234;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.Stack;

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<>();           // store half node
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;     // odd count, [slow, tail] N/2+1, now slow point to middle node
        while (slow != null) {    // also can !s.isEmpty();   slow from left to right, stack from right to left;
            if (s.pop() != slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }
}