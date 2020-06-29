package com.janhen.coding.leetcode.ds.linkedlist.quality.solution234;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.Stack;

class Solution {
    // time: O(n), space: O(n)
    public boolean isPalindrome(ListNode head) {
        // store left half nodes
        Stack<Integer> s = new Stack<>();
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // handle odd count condition, now Count([slow, tail]) = N/2+1
        if (fast != null)
            slow = slow.next;

        // use slow to iterate right half nodes
        while (slow != null) {    // also can !s.isEmpty();   slow from left to right, stack from right to left;
            if (s.pop() != slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }
}