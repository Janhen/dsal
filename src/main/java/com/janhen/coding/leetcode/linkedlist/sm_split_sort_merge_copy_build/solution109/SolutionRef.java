package com.janhen.coding.leetcode.linkedlist.sm_split_sort_merge_copy_build.solution109;

// 109. Convert Sorted List to Binary Search Tree
//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// medium  787:58

import com.janhen.coding.leetcode.structures.ListNode;
import com.janhen.coding.leetcode.structures.TreeNode;

// 1 ms, faster than 99.17%
class SolutionRef {

    // 数组索引式构建
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        int len = length(head);
        return dfs(head, 0, len - 1);
    }

    private TreeNode dfs(ListNode head, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(head.val);

        int mid = l + (r - l) / 2;
        ListNode midNode = head;
        for (int i = l; i < mid; i ++)
            midNode = midNode.next;

        TreeNode root = new TreeNode(midNode.val);
        root.left = dfs(head, l, mid - 1);
        root.right = dfs(midNode.next, mid + 1, r);
        return root;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        return len;
    }
}