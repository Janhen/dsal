package com.janhen.coding.leetcode.ds.linkedlist.quality.solution234;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.Stack;

class Solution {
  // time: O(n), space: O(n)
  public boolean isPalindrome(ListNode head) {
    // 1. store left half nodes
    Stack<Integer> stack = new Stack<>();
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      stack.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }

    // 2. handle odd count condition, now Count([slow, tail]) = N/2+1
    if (fast != null)
      slow = slow.next;

    // 3. use slow to iterate right half nodes
    while (slow != null) {    // also can !s.isEmpty();   slow from left to right, stack from right to left;
      if (stack.pop() != slow.val)
        return false;
      slow = slow.next;
    }
    return true;
  }
}