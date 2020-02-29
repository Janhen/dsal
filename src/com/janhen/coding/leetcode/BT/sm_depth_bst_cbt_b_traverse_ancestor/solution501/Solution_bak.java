package com.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution501;

import com.janhen.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution_bak {
    private int      curCnt= 1;

    private int      maxCnt= 1;

    private TreeNode pre;            // record excepted equal

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();   // NOTE: have many maxCnt, record maxCnt val
        inOrder(root, list);
        int[] ret = list.stream().mapToInt(p -> p.intValue()).toArray();
        return ret;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        if (pre != null) {                     // modify curCnt
            if (pre.val == node.val)
                curCnt ++;
            else
                curCnt = 1;
        }
        pre = node;

        if (curCnt > maxCnt) {                     // modify maxCnt OR add element
            list.clear();
            list.add(node.val);
            maxCnt = curCnt;
        } else if (curCnt == maxCnt) {
            list.add(node.val);
        }
        inOrder(node.right, list);
    }
}