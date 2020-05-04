package main.java.janhen.swordoffer.a_base.problem22;

import main.java.janhen.swordoffer.structures.ListNode;

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        while (fast != null && k -- > 0)
            fast = fast.next;
        if (k > 0)
            return null;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
