package com.janhen.coding.swordoffer.a_base.problem23;

import com.janhen.coding.swordoffer.structures.ListNode;

public class Solution {
    // time: O(N), space: O(1)
    public ListNode EntryNodeOfLoop(ListNode head) {
        // step1: check whether or not have cycle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        // step2: calculate cycle node count
        int loopSize = lengthOfLoop(fast);

        // step3: X = X+Y to find merge node, fast and slow point...
        fast = head;
        slow = head;
        while (loopSize-- > 0) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static int lengthOfLoop(ListNode head) {
        if (head == null) {
            return 0;
        }
        int loopSize = 1;
        ListNode cur = head;
        cur = cur.next;
        while (cur != head) {
            loopSize++;
            cur = cur.next;
        }
        return loopSize;
    }
}
