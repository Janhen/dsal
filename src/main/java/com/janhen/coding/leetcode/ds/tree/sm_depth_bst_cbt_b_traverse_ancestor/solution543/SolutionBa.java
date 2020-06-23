package com.janhen.coding.leetcode.ds.tree.sm_depth_bst_cbt_b_traverse_ancestor.solution543;

import com.janhen.coding.leetcode.structures.TreeNode;

class SolutionBa {

    // 与深度相关
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        ReturnData data = process(root);
        return data.diameter - 1;
    }

    // Probability analysis :
    // P1 : 左树的最远距离
    // P2 : 右树的最远距离
    // P3 : 经过当前 x 节点的最远距离,  根据 左树的最远距离, 和右树的最远距离, 求出其最远距离

    // message body :
    // distance
    // h  :  左树 or 右树上节点到当前的最远
    private ReturnData process(TreeNode root) {
        if (root == null)
            return new ReturnData(0, 0);

        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);

        int includeSelfDistance = leftData.height + rightData.height + 1;
        int includeSelfHeight = Math.max(leftData.height, rightData.height) + 1;
        int curDiameter = Math.max(includeSelfDistance, Math.max(leftData.diameter, rightData.diameter));
        return new ReturnData(curDiameter, includeSelfHeight);
    }

    // 可能性:
    // P1: 左边半径大于右边半径, 且其不为当前的左孩子
    // P2: 右边直径大于左边直径, 且其不为当前节点的右孩子
    // P3: 左边直径的根节点为当前节点的左孩子, 右边直径的根节点为当前节点的右孩子
    class ReturnData {
        int diameter;
        int height;

        ReturnData(int d, int h) {
            diameter = d;
            height = h;
        }
    }
}