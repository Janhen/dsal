package com.janhen.coding.swordoffer.tree.problem54;

import com.janhen.coding.swordoffer.structures.TreeNode;

public class Solution1 {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k)
            return;
        inOrder(root.left, k);
        if (++ cnt == k)
            ret = root;
        inOrder(root.right, k);
    }
}
