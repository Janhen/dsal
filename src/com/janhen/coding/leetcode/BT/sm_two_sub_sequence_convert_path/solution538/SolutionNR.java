package com.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution538;

import com.janhen.leetcode.structures.TreeNode;

import java.util.Stack;

class SolutionNR {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        int sum = 0;
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;
        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.right;                       // Tree 的 RDL 遍历方式
            }
            cur = s.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }
        return root;
    }
}