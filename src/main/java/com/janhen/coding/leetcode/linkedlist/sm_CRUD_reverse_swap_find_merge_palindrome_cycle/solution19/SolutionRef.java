package com.janhen.coding.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution19;

//19. Remove Nth Node From End of List
//        https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionRef {

    // 1  len-1
    // 2  len-2
    // nthFromEnd == [len-nthFromBegin]
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        int len = 0;
        for(ListNode cur = head ; cur != null ; cur = cur.next)
            len ++;
        int k = len - n;
        assert k >= 0;
        ListNode cur = first;    // -1 index
        for(int i = 0 ; i < k ; i ++)
            cur = cur.next;               // skip loop k-1 index
        cur.next = cur.next.next;
        return first.next;
    }
}