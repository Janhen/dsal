package main.java.janhen.swordoffer.tree.problem7;

import main.java.janhen.swordoffer.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, Integer> inorderNumIndex = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            inorderNumIndex.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)  return null;

        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = inorderNumIndex.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);       /* 索引范围控制 [a,b] b-a=len-1 */
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inIndex + 1);
        return root;
    }
}
