package com.janhen.coding.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution19;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {

    // like find nthFromEnd before node
    // 定位到底 n 个节点，记录前指针
    // 两个指针同时走到底，前指针指向的是倒数第 n 个节点的前一个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n -- > 0)      // make fast is nth
            fast = fast.next;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        while (fast != null) {         // find nthFromEnd previous node
            pre = pre.next;
            fast = fast.next;
        }
        pre.next = pre.next.next;
        return first.next;
    }
}