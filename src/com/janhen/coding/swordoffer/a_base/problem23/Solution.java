package com.janhen.coding.swordoffer.a_base.problem23;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead, slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // have cycle
            if (slow == fast) {
                break;
            }
        }
        // have no cycle
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
