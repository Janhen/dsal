package com.janhen.swordoffer.tree.problem54;

import com.janhen.swordoffer.structures.TreeNode;

public class SolutionR {

    int cnt = 0;

    TreeNode KthNode(TreeNode root, int k) {
        if (root == null)
            return null;
        TreeNode node = KthNode(root.left, k);
        if (node != null)
            return node;
        cnt++;
        if (cnt == k) {
            return root;
        }
        node = KthNode(root.right, k);
        if (node != null)
            return node;
        return null;
    }

}
