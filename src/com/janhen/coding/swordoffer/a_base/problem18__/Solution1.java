package com.janhen.coding.swordoffer.a_base.problem18__;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution1 {
    // 不适用缓冲区：遍历
    // time：O(n^2), space：O(1)
    public ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode runner = cur;
            // eliminate cur node equal node
            while (runner.next != null) {
                if (runner.next.val == cur.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
