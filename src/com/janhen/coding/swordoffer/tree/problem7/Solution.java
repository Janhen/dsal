package com.janhen.coding.swordoffer.tree.problem7;

import com.janhen.coding.swordoffer.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // record inorder value(root.value) -> index
    private Map<Integer, Integer> inorderNumIdxMap = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            inorderNumIdxMap.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        // create root
        TreeNode root = new TreeNode(pre[preL]);
        // root index in inOrderTraverse
        int inIdx = inorderNumIdxMap.get(root.val);
        int leftTreeSize = inIdx - inL;
        // split two partition by root element, to left tree, right tree
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);       /* 索引范围控制 [a,b] b-a=len-1 */
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inIdx + 1);
        return root;
    }
}
