package com.janhen.coding.leetcode.binarytree.sm_depth_bst_cbt_b_traverse_ancestor.solution653;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.*;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // convert to sorted list to find
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k)
                return true;
            else if (sum < k)
                i ++;
            else
                j --;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}