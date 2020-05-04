package main.java.janhen.swordoffer.tree.problem68_2;

import main.java.janhen.swordoffer.structures.TreeNode;

public class Solution {
    // 在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right                      // left tree have not, must all in right tree
                : right == null ? left : root;             // right tree have not all p,q;
    }

}
