package main.java.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution160;

import main.java.janhen.leetcode.structures.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode list1, ListNode list2) {
        ListNode cur1 = list1, cur2 = list2;
        while (cur1 != cur2) {
            cur1 = cur1 != null ? cur1.next : list2;
            cur2 = cur2 != null ? cur2.next : list1;
        }
        return cur1;
    }
}