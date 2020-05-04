package main.java.janhen.swordoffer.a_base.problem24;

import main.java.janhen.swordoffer.structures.ListNode;

public class Solution {

    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
