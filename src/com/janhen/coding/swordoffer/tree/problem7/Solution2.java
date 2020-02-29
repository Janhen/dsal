package com.janhen.swordoffer.tree.problem7;

import com.janhen.swordoffer.structures.TreeNode;

import java.util.Arrays;

public class Solution2 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) return null;

        int i = findRootIndexInInorder(in, pre[0]);
        TreeNode root = new TreeNode(pre[0]);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
        return root;
    }

    private int findRootIndexInInorder(int[] in, int rootVal) {
        for (int i = 0;i < in.length; i ++) {
            if (in[i] == rootVal) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }
}
