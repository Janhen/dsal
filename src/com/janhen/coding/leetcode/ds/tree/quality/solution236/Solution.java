package com.janhen.coding.leetcode.ds.tree.quality.solution236;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. pre order traverse and collect node parent record
        // tree node -> parent tree node
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {  // ALSO can in advance skip     !parent.containsKey(p) || !parent.containsKey(q),
            //  O(1)
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

        // 2. collect p tree all ancestor from newer to older and compare q tree ancestor
        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parent.get(p);
        }

        // 3. find lowest common ancestor in p ancestor
        while (!pAncestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}