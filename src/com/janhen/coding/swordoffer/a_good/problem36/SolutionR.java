package com.janhen.swordoffer.a_good.problem36;

import com.janhen.swordoffer.structures.TreeNode;

public class SolutionR {

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private TreeNode head;
    private TreeNode pre;
    public void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        if (pre == null) {
            pre = node;
            head = node;
        } else {
            node.left = pre;
            pre.right = node;
            pre = node;
        }
        inOrder(node.right);
    }
}
