package main.java.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution21;

import main.java.janhen.leetcode.structures.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(-1);
        ListNode tail = first;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null)
            tail.next = l2;
        if (l2 == null)
            tail.next = l1;
        return first.next;
    }
}