package main.java.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution110;

import main.java.janhen.leetcode.structures.TreeNode;

class SolutionRef {

    // 提前跳出 DFS
    public boolean isBalanced(TreeNode root) {
        return getHeightAndBalance(root).isB;
    }

    private static final int PRESENT = -1;
    private Pair getHeightAndBalance(TreeNode root) {
        if (root == null)
            return new Pair(true, 0);

        Pair leftRes = getHeightAndBalance(root.left);
        if (!leftRes.isB)
            return new Pair(false, PRESENT);

        Pair rightRes = getHeightAndBalance(root.right);
        if (!rightRes.isB)
            return new Pair(false, PRESENT);

        if (Math.abs(leftRes.height - rightRes.height) > 1)
            return new Pair(false, PRESENT);
        return new Pair(true, 1 + Math.max(leftRes.height, rightRes.height));
    }

    class Pair {
        boolean isB;
        int height;

        Pair(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }
}