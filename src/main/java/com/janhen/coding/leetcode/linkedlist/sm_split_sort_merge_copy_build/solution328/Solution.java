package com.janhen.coding.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution328;

import com.janhen.coding.leetcode.structures.ListNode;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;    // 保存用于最后直接链接
        while (odd.next != null && even.next != null) {          // even is fast than odd one step ⇔ odd.next != null && even.next != null
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
