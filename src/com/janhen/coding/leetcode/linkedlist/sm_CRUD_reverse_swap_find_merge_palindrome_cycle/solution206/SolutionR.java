package com.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution206;

//206. Reverse Linked List
//        https://leetcode.com/problems/reverse-linked-list/description/

import com.janhen.leetcode.structures.ListNode;


class SolutionR {

    // 递归动态拼接实现
    // 2->3->4<-5<-6    cur:head 3,  reverseHead=6, head.next=4

    // 1->2->3->4->5
    // 1->2<-3<-4<-5
    // head
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode reverseHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;               // as tail
        return reverseHead;
    }
}