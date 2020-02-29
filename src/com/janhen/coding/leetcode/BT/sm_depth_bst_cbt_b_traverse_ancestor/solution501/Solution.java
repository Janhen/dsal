package com.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution501;

import com.janhen.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int curCnt=1;
    private int maxCnt=1;
    private TreeNode pre;   // record cur equal
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();   // record maxCnt val
        inOrder(root, list);
        return list.stream().mapToInt(p -> p.intValue()).toArray();
    }

    // inorder is ordered 1,1,1,2,2,3,4,5,5,5
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        if (pre != null)
            curCnt = (pre.val == node.val ? curCnt + 1 : 1);
        pre = node;
        if (maxCnt < curCnt) {
            list.clear();
            list.add(node.val);
            maxCnt = curCnt;
        } else if (curCnt == maxCnt) {           // NOTE: must
            list.add(node.val);
        }
        inOrder(node.right, list);
    }
}