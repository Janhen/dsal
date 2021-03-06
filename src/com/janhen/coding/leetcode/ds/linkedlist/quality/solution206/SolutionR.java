package com.janhen.coding.leetcode.ds.linkedlist.quality.solution206;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionR {
    // 递归动态拼接实现
    // 2->3->4<-5<-6    cur:head 3,  reverseHead=6, head.next=4

    // 1->2->3->4->5
    // 1->2<-3<-4<-5
    // head
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;               // as tail
        return reverseHead;
    }
}