package main.java.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution206;

import main.java.janhen.leetcode.structures.ListNode;

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