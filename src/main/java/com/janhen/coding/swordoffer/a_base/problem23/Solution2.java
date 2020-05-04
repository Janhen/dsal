package main.java.janhen.swordoffer.a_base.problem23;

import main.java.janhen.swordoffer.structures.ListNode;

public class Solution2 {

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
        if (fast == null || fast.next == null)
            return null;

        // step2: calculate cycle node count
        // note: at this time fast == slow, must from 1 to begin
        int loopSize = 1;
        fast = fast.next;
        while (fast != slow) {
            loopSize++;
            fast = fast.next;
        }

        // step3: X = X+Y to find merge node
        fast = head;
        slow = head;
        while (loopSize-- > 0)
            fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
