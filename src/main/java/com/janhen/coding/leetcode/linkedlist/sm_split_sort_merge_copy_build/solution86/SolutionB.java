package main.java.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution86;

import main.java.janhen.leetcode.structures.ListNode;

class SolutionB {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = null, lessTail = null;
        ListNode greaterHead = null, greaterTail = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;    // truncate list, cur as need to joint node
            if (cur.val >= x) {
                if (greaterHead == null) {
                    greaterHead = cur;
                    greaterTail = greaterHead;
                }
                else {
                    greaterTail.next = cur;
                    greaterTail = cur;
                }
            }
            else {
                if (lessHead == null) {
                    lessHead= cur;
                    lessTail = lessHead;
                }
                else {
                    lessTail.next = cur;
                    lessTail = cur;
                }
            }
            cur = next;
        }
        if (lessHead == null) return greaterHead;
        lessTail.next = greaterHead;
        return lessHead;
    }
}