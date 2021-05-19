package com.janhen.coding.swordoffer.a_base.problem22;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    // 快慢指针定位
    // time: O(N), space: O(1)
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head;
        while (fast != null && k-- > 0) {
            fast = fast.next;
        }
        // check k not exceed list node length
        if (k > 0) {
            return null;
        }
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
