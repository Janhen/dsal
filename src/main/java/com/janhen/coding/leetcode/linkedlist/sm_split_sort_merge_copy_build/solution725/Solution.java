package com.janhen.coding.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution725;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = length(root);
        ListNode[] parts = new ListNode[k];
        int size = len / k, remain = len % k;
        ListNode pre = null, cur = root;
        for (int i = 0; i < k && cur != null; i ++) {         // two iteration pointer
            parts[i] = cur;
            int curSize = size + (remain -- > 0 ? 1 : 0);
            for (int j = 0; j < curSize; j ++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;            // split
        }
        return parts;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        return len;
    }
}