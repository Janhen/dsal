package com.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution725;

import com.janhen.leetcode.structures.ListNode;

class Solution_bak {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        int size = len / k, remain = len % k;      // handle size
        ListNode[] parts = new ListNode[k];
        cur = root;
        ListNode pre = null;
        for (int i = 0; i < k & cur != null; i ++) {
            parts[i] = cur;
            int curSize = size + (remain -- > 0 ? 1 : 0);
            for (int j = 0; j < curSize; j ++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null; // cut
        }
        return parts;
    }

}