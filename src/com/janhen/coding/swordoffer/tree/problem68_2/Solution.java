package com.janhen.coding.swordoffer.tree.problem68_2;

// 236. Lowest Common Ancestor of a Binary Tree
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/*

Medium

1563

125

Favorite

Share
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]




Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be 【unique】.
p and q are different and both values will exist in the binary tree.
 */

import com.janhen.coding.swordoffer.structures.TreeNode;

import java.util.*;

class Solution {

    // 通过 map 模拟向上的指针
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);   // init and as terminal condition
        // 1. preorder traverse(dfs) to record treeNode -> parentNode
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                parent.put(cur.right, cur);
                stack.push(cur.right);
            }
            if (cur.left != null) {
                parent.put(cur.left, cur);
                stack.push(cur.left);
            }
        }
        // 2. record all p tree parent tree node
        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parent.get(p);
        }
        // 3. find q tree all parent tree node is equal p parent tree node
        while (q != null) {
            if (pAncestors.contains(q))
                return q;
            q = parent.get(q);
        }
        throw new IllegalArgumentException();
    }
}