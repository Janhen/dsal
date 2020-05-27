package com.janhen.coding.leetcode.binarytree.sm_depth_bst_cbt_b_traverse_ancestor.solution501;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int curCnt=1;

    private int maxCnt=1;

    private TreeNode pre;   // record cur equal

    /*
    time: O(n)
     */
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();   // record maxCnt val
        inOrder(root, list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    // in order is ordered 1,1,1,2,2,3,4,5,5,5
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        inOrder(node.left, list);

        // traverse d node and record current node.val occur frequency
        if (pre != null)
            curCnt = (pre.val == node.val ? curCnt + 1 : 1);
        pre = node;

        // judge condition to collect result
        if (maxCnt < curCnt) {
            // clear before collected maxCnt frequency
            list.clear();
            list.add(node.val);
            maxCnt = curCnt;
        } else if (curCnt == maxCnt) {           // NOTE: must
            list.add(node.val);
        }

        inOrder(node.right, list);
    }
}