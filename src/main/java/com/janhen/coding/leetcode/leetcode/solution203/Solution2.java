package main.java.janhen.leetcode.leetcode.solution203;


import main.java.janhen.leetcode.structures.ListNode;

public class Solution2 {

    // non recursion
    public ListNode removeElements(ListNode head, int val) {

        // init handle : find first node that not equal val
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null)
            return null;

        ListNode prev = head;
        while (prev != null && prev.next != null) {
            if (prev.next.val == val) {
                ListNode cur = prev.next;
                prev.next = cur.next;
                cur.next = null;
            } else
                prev = prev.next;
        }
        return head;
    }

}
