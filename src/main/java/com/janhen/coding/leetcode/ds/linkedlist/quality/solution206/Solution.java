package com.janhen.coding.leetcode.ds.linkedlist.quality.solution206;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {

    // 迭代实现
    // o <- o <- o    o -> o -> NULL
    //           |    |    |
    //          pre  cur  next

    // o <- o <- o <- o <- o <- NULL
    //                     |     |
    //                    pre    cur
    //  0 ms, faster than 100.00%
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {                   // can use for count reverse
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}