package com.janhen.swordoffer.tree.problem68_2;

import com.janhen.swordoffer.structures.TreeNode;

import java.util.*;

public class Solution_my2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = geneParentMap(root, p, q);
        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parentMap.get(p);
        }
        while (q != null) {
            if (pAncestors.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        throw new IllegalArgumentException();
    }

    private Map<TreeNode, TreeNode> geneParentMap(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parentMap.put(root, null);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                parentMap.put(cur.right, cur);
                stack.push(cur.right);
            }
            if (cur.left != null) {
                parentMap.put(cur.left, cur) ;
                stack.push(cur.left);
            }
        }
        return parentMap;
    }
}
