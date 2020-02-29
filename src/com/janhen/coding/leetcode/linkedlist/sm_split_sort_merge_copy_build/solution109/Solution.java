package com.janhen.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution109;

import com.janhen.leetcode.structures.ListNode;
import com.janhen.leetcode.structures.TreeNode;

class Solution {
    // 截断两个链表递归拼接
    // 找到中间节点，作为该树的根节点
    // 左右两部分分别为两个子问题
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode preMid = preMid(head);           // not need precise odd OR even count
        ListNode mid = preMid.next;
        preMid.next = null;                       // cut ⇒ two list

        TreeNode root = new TreeNode(mid.val);   // head... preMid
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);   // Note: mid.next ... tail
        return root;
    }

    private ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}