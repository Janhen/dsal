package com.janhen.swordoffer.tree.problem68_2;

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

import com.janhen.swordoffer.structures.TreeNode;

import java.util.*;

// 15 ms, faster than 21.13%
//23.5 MB, less than 27.42%
class Solution2_ {

    // 遍历直到 p,q parent 进入
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();          /* 类似并查集中保存parent进行路径压缩 */
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        parent.put(root, null);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {        /* 提早跳出循环, 查询相较于判断stack为空开销大, 常数项差别 */
            TreeNode top = s.pop();
            if (top.left != null) {
                parent.put(top.left, top);
                s.push(top.left);
            }
            if (top.right != null) {
                parent.put(top.right, top);
                s.push(top.right);
            }
        }
        Set<TreeNode> pAncestors = new HashSet<>();
        while (p != null) {
            pAncestors.add(p);
            p = parent.get(p);
        }
        while (!pAncestors.contains(q)) {           /* 在p 祖先中查找q的祖先, 不断向上层查找 */
            q = parent.get(q);
        }
        return q;
    }
}