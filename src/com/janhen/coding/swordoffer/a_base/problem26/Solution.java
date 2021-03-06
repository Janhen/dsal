package com.janhen.coding.swordoffer.a_base.problem26;

import com.janhen.coding.swordoffer.structures.TreeNode;

public class Solution {
    // preOder traverse DFS to find value equal tree node
    // then compare is or not subtree
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            if (isSubtreeFromNode(root1, root2)) {
                return true;
            }
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtreeFromNode(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubtreeFromNode(root1.left, root2.left) && isSubtreeFromNode(root1.right, root2.right);
    }
}
