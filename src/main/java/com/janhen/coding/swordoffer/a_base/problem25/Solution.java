package main.java.janhen.swordoffer.a_base.problem25;

import main.java.janhen.swordoffer.structures.ListNode;

public class Solution {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode first = new ListNode(-1);
        ListNode tail = first;
        while (list1 != null && list2 != null) {
           if (list1.val <= list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null)
            tail.next = list2;
        if (list2 == null)
            tail.next = list1;
        return first.next;
    }
}
