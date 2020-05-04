package main.java.janhen.swordoffer.a_base.problem24;

import main.java.janhen.swordoffer.structures.ListNode;

public class Solution1 {
    public ListNode ReverseList(ListNode head) {
        // head insert
        ListNode first = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = first.next;
            first.next = head;
            head = next;
        }
        return first.next;
    }
}
