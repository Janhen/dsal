package com.janhen.coding.leetcode.ds.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution234;

import com.janhen.coding.leetcode.structures.ListNode;

class SolutionF_try {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode preMid = preMid(head);
        ListNode l1 = head;
        ListNode l2 = reverse(preMid.next);         // Error: isEqual 绝对精确时错误
        return isEqual(l1, l2);
    }

    // 不可判断是否是奇数还是偶数个
    private ListNode preMid(ListNode head) {
        ListNode fast = head, slow = head, pre = null;    // record slow previous node
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    private ListNode reverse(ListNode list) {
        ListNode pre = null;
        ListNode next = null;
        while (list != null) {
            next = list.next;
            list.next = pre;
            pre = list;
            list = next;
        }
        return pre;
    }
}