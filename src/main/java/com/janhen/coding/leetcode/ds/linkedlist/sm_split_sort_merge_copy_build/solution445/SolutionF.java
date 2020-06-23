package com.janhen.coding.leetcode.ds.linkedlist.sm_split_sort_merge_copy_build.solution445;

import com.janhen.coding.leetcode.structures.ListNode;

import java.util.Stack;

class SolutionF {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // make list to "reverse"
        Stack<ListNode> s1 = buildStack(l1);
        Stack<ListNode> s2 = buildStack(l2);

        int carry = 0;
        ListNode first = new ListNode(-1);             // NOTE: make result to reverse
        // condition:
        //   s1,s2 not empty: slow bit all have element
        //   s1/s2 empty:     one list high bit not have element
        //   carry is 0:
        //   carry is not 0:
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            // iterate from slow bit to high bit
            int val = (s1.isEmpty() ? 0 : s1.pop().val) + (s2.isEmpty() ? 0 : s2.pop().val) + carry;
            carry = val / 10;

            ListNode node = new ListNode(val % 10);
            node.next = first.next;                           // 头插法逆序 7087 ⇒ 7807
            first.next = node;
        }
        return first.next;
    }

    private Stack<ListNode> buildStack(ListNode l) {
        Stack<ListNode> s = new Stack<>();
        // modify list reference
        while (l != null) {
            s.push(l);
            l = l.next;
        }
        return s;
    }
}