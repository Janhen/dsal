package com.janhen.coding.leetcode.ds.linkedlist.operate.solution23;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution2 {
    // Merge sort
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSortList(lists, 0, lists.length - 1);
    }

    private ListNode mergeSortList(ListNode[] lists, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        if (lo == hi) {
            return lists[lo];
        }

        int mid = lo + (hi - lo) / 2;
        ListNode left = mergeSortList(lists, lo, mid);
        ListNode right = mergeSortList(lists, mid + 1, hi);
        return merge(left, right);
    }

    // 合并两个排序的链表
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}