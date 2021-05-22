package com.janhen.coding.swordoffer.a_base.problem23;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    // time: O(N), space: O(1)
    public ListNode EntryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // find loop node
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // judge is or not have loop
        if (fast != slow) return null;
        // get loop size
        ListNode cur = fast;
        int loopSize = 1;
        // init as one element
        cur = cur.next;
        // fast as iiterate guard
        while (cur != fast) {
            cur = cur.next;
            loopSize ++;
        }
        // fast run loop size
        fast = head;
        while (loopSize -- > 0) {
            fast = fast.next;
        }
        slow = head;
        // fast and slow together run util fast = slow
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
