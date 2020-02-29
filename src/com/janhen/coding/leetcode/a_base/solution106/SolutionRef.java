package com.janhen.leetcode.a_base.solution106;

import com.janhen.leetcode.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

class SolutionRef {

    private Map<Integer, Integer> inorderNumIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        assert inorder.length == postorder.length;

        for (int i = 0; i < inorder.length; i ++)
            inorderNumIndex.put(inorder[i], i);

        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    // [inL, inR]
    private TreeNode buildTree(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
        if (inL > inR || postL > postR) return null;

        TreeNode root = new TreeNode(postorder[postR]);
        int index = inorderNumIndex.get(root.val);
        int leftSize = index - inL;

        root.left = buildTree(inorder, inL, index-1, postorder, postL, postL+leftSize-1);
        root.right = buildTree(inorder, index+1, inR, postorder, postL+leftSize, postR - 1);
        return root;
    }
}