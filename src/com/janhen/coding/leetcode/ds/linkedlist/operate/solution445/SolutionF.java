package com.janhen.coding.leetcode.ds.linkedlist.operate.solution445;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.Stack;

class SolutionF {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. make list to "reverse"
        Stack<ListNode> stack1 = buildStack(l1);
        Stack<ListNode> stack2 = buildStack(l2);

        // 2. iterate and calculate list
        int carry = 0;
        ListNode first = new ListNode(-1);
        // condition:
        //   s1,s2 not empty: slow bit all have element
        //   s1/s2 empty:     one list high bit not have element
        //   carry is 0:
        //   carry is not 0:
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            // iterate from slow bit to high bit
            int val = (stack1.isEmpty() ? 0 : stack1.pop().val) + (stack2.isEmpty() ? 0 : stack2.pop().val) + carry;
            carry = val / 10;
            val = val % 10;
            ListNode node = new ListNode(val);

            // 3. head insert to reverse
            node.next = first.next;
            first.next = node;
        }
        return first.next;
    }

    private Stack<ListNode> buildStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // modify list reference
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        return stack;
    }
}