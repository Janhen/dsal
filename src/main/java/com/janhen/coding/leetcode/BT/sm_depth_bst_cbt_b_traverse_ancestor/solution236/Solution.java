package main.java.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution236;

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {  // ALSO can in advance skip     !parent.containsKey(p) || !parent.containsKey(q),  O(1)
            root = stack.pop();
            if (root.right != null) {
                parent.put(root.right, root);                   // record parent pointer
                stack.push(root.right);
            }
            if (root.left != null) {
                parent.put(root.left, root);
                stack.push(root.left);
            }
        }

        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parent.get(p);
        }
        while (!pAncestors.contains(q))
            q = parent.get(q);
        return q;
    }

}