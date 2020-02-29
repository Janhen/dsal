package com.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution86;

import com.janhen.leetcode.structures.ListNode;

class Solution {
    // 单个链表的分割
    public ListNode partition(ListNode head, int x) {
        ListNode first1 = new ListNode(-1), first2 = new ListNode(-1);
        ListNode tail1 = first1, tail2 = first2;
        while (head != null) {
            if (head.val < x) {
                tail1.next = head;
                tail1 = head;
            } else {
                tail2.next = head;
                tail2 = head;
            }
            head = head.next;
        }
        tail2.next = null;                  // as all list tail ??
        tail1.next = first2.next;
        return first1.next;
    }
}