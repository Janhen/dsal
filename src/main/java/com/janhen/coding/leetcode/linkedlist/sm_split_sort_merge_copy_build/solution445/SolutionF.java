package main.java.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution445;

import main.java.janhen.leetcode.structures.ListNode;

import java.util.Stack;

class SolutionF {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = buildStack(l1);
        Stack<ListNode> s2 = buildStack(l2);
        int carry = 0;
        ListNode first = new ListNode(-1);             // NOTE: make result to reverse
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {        // can enter the loop
            int val = (s1.isEmpty() ? 0 : s1.pop().val) + (s2.isEmpty() ? 0 : s2.pop().val) + carry;
            carry = val / 10;
            ListNode node = new ListNode(val % 10);
            node.next = first.next;                           // 头插法逆序 7087 ⇒ 7807
            first.next = node;
        }
        return first.next;
    }

    private Stack<ListNode> buildStack(ListNode list) {
        Stack<ListNode> s = new Stack<>();
        while (list != null) {
            s.push(list);
            list = list.next;
        }
        return s;
    }
}