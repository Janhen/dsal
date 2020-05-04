package main.java.janhen.swordoffer.tree.problem7;

import main.java.janhen.swordoffer.structures.TreeNode;

public class Solution3 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if(preL > preR || inL > inR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        for(int i=inL; i<=inR; i++) {
            if(in[i] == pre[preL]) {
                int leftSize = i - inL;
                root.left = reConstructBinaryTree(pre, preL+1, preL+leftSize, in, inL, i-1);
                root.right = reConstructBinaryTree(pre, preL+leftSize+1, preR, in, i+1, inR);
                break;
            }
        }
        return root;
    }
}
