package com.janhen.coding.swordoffer.a_base.problem55_2;

import com.janhen.coding.swordoffer.structures.TreeNode;
import javafx.util.Pair;

public class SolutionB {

    public boolean IsBalanced_Solution(TreeNode root) {
        return height(root).getValue();
    }

    // record height AND isBalanced, can skip loop in advance
    private Pair<Integer, Boolean> height(TreeNode root) {
        if (root == null)
            return new Pair<>(0, true);
        Pair<Integer, Boolean> left = height(root.left);
        if (!left.getValue())
            return left;
        Pair<Integer, Boolean> right = height(root.right);
        if (!right.getValue())
            return right;
        if (Math.abs(right.getKey() - left.getKey()) > 1) {
            return new Pair<>(-1, false);       // no need to calculate after this
        }
        return new Pair<>(1 + Math.max(left.getKey(), right.getKey()), true);
    }
}
