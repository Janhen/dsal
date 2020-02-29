package com.janhen.leetcode.linkedlist.sm_CRUD_reverse_swap_find_merge_palindrome_cycle.solution142;

import com.janhen.leetcode.structures.ListNode;

public class SolutionF1 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null)
            return null;   // no loop

        int loopCnt = lengthOfLoop(fast);
        fast = head;
        while (loopCnt -- > 0)
            fast = fast.next;
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private int lengthOfLoop(ListNode head) {
        int loopSize = 1;
        ListNode cur = head;
        cur = cur.next;
        while (cur != head) {
            loopSize ++;
            cur = cur.next;
        }
        return loopSize;
    }
}