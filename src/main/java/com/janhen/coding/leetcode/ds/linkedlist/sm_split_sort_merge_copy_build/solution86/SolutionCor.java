package com.janhen.coding.leetcode.ds.linkedlist.sm_split_sort_merge_copy_build.solution86;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionCor {

    // 使用头插法来实现: 无法保证原始顺序
    // 两个子链表的顺序为反序
    // [1,4,3,2,5,2]
    // 3
    //
    //[2,2,1,5,3,4]
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = null;
        ListNode greaterHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val >= x) {    // cur as head node
                cur.next = greaterHead;      // head insert, traversal element as head
                greaterHead = cur;
            }
            else {
                cur.next = lessHead;
                lessHead = cur;
            }
            cur = next;
        }
        if (lessHead == null)
            return greaterHead;
        ListNode newHead = lessHead;
        while (lessHead.next != null)          // find less list tail
            lessHead = lessHead.next;
        lessHead.next = greaterHead;
        return newHead;
    }
}