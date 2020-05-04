package main.java.janhen.swordoffer.a_base.problem55;

import main.java.janhen.swordoffer.structures.TreeNode;

public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
