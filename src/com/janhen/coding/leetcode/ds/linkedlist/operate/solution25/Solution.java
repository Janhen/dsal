package com.janhen.coding.leetcode.ds.linkedlist.operate.solution25;

import com.janhen.coding.leetcode.structures.ListNode;

/*
time: O(N), space: O(1)

 可以递归操作, 有两种情况：
 1. 就是压根没有k个node，那么我们直接保持这个k-group不动返回head
 2. 如果有k个node的话，那么我们先找到第k个node之后的递归结果 node = nxt，然后反转前面k个node，让反转结果的结尾 tail.next = nxt
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        // 1. dummy head to record head
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;

        // 2. use head to iterate and i record index
        int N = 0;
        while (cur != null) {
            N++;
            // 3. collect result and reset begin
            if (N % k == 0) {
                pre = reverse(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
        // 4. return real head
        return first.next;
    }

    /**
     * 反转 [begin.next,...,end) 范围的链表并返回反转后的最后一个元素
     *
     * @param begin 之前的节点(不进行反转)
     * @param end   终止的节点
     * @return 反转后最后最后一个元素(临近end)
     */
    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode cur = begin.next;
        ListNode next = null;
        ListNode first = begin.next;
        ListNode pre = begin;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        begin.next = pre;
        first.next = cur;
        return first;
    }
}