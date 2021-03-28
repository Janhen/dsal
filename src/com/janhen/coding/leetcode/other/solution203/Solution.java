package com.janhen.coding.leetcode.other.solution203;

//203. Remove Linked List Elements
//        https://leetcode.com/problems/remove-linked-list-elements/description/


import com.janhen.coding.leetcode.structures.ListNode;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

    }
}

//            if (head.val == val) {
//                return removeElements(head.next, val);
//            } else {
//                head.next = removeElements(head.next, val);
//            }
//            return head;
