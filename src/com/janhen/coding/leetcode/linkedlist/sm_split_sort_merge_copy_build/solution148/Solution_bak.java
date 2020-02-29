package com.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution148;

import com.janhen.leetcode.structures.ListNode;

// 自底向上的归并排序
// 无需递归，只需迭代
// 没有通过数组索引直接获取元素
class Solution_bak {

    // 分成左右两个链表, 分别对左右不分进行排序，之后合并两个排序的链表即可
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // step1: split list to two list size∈{N/2,N/2},{N/2,N/2+1}
        ListNode pre = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; // now pre is first list last element, slow is second list first element

        // step2: sort left and right
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step3: merge to return result
        return merge(l1, l2);
    }

    // two list to merge
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}