package main.java.janhen.swordoffer.a_base.problem27;

import main.java.janhen.swordoffer.structures.TreeNode;

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null)
            return ;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        Mirror(root.left);
        Mirror(root.right);
    }
}
