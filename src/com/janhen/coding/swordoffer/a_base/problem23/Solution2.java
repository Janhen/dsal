package com.janhen.coding.swordoffer.a_base.problem23;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution2 {
    public ListNode EntryNodeOfLoop(ListNode head) {
        // find merge position
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // have cycle
            if (slow == fast) {
                break;
            }
        }
        // check have no cycle
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
