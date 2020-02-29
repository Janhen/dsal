package com.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution100;

import com.janhen.leetcode.structures.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

class SolutionDFS4 {
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;

        Stack<Pair<TreeNode, TreeNode>> s = new Stack<>();
        s.push(new Pair<>(root1, root2));
        while (!s.isEmpty()) {
            TreeNode node1 = s.peek().getKey();
            TreeNode node2 = s.pop().getValue();

            if (node1 == null && node2 == null)    // null leaf
                continue;
            else if (node1 == null || node2 == null)   // broken
                return false;
            else if (node1.val != node2.val)      // complete
                return false;

            s.push(new Pair<>(node1.left, node2.left));              // can not insure left and right node whether or not is null
            s.push(new Pair<>(node1.right, node2.right));
        }
        return s.isEmpty();
    }
}