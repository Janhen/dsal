package com.janhen.coding.swordoffer.tree.problem68_2;

// 普通二叉树的最近公共祖先
// Leetcode : 236. Lowest Common Ancestor of a Binary Tree
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

import com.janhen.coding.swordoffer.structures.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SolutionB2 {

    // todo 非使用List 添加引用方式, 直接取到 TreeNode 作为的头结点??
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        List<TreeNode> l1 = new LinkedList<>();
        List<TreeNode> l2 = new LinkedList<>();
        findList(root, p, l1);
        findList(root, q, l2);
        TreeNode firstCommon = findCommonNode(l1, l2);
        return firstCommon;
    }

    /* 找到根节点到某个节点的路径 */
    private boolean findList(TreeNode root, TreeNode p, List<TreeNode> path) {    // path 保存从根到指定位置路径上的引用
        if (root.left == null && root.right == null) {
            if (root.val == p.val) {
                path.add(p);
                return true;
            } else {
                return false;
            }
        }
        if (root.val == p.val) {
            path.add(p);
            return true;
        }
        path.add(root);
        if (root.left != null) {
            boolean hasFound = findList(root.left, p, path);
            if (hasFound) {
                return true;
            }
        }
        if (root.right != null) {
            boolean hasFound = findList(root.right, p , path);
            if (hasFound) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    /* 3->5, 3->5->2->4 */
    private TreeNode findCommonNode(List<TreeNode> l1, List<TreeNode> l2) {
        TreeNode pre = null;
        TreeNode node1 = null, node2 = null;
        int minLen = Math.min(l1.size(), l2.size());
        for (int i = 0; i < minLen; i ++) {
            node1 = l1.get(i);
            node2 = l2.get(i);
            if (node1.val != node2.val) {       /* reference compare?? */
                return pre;
            }
            pre = node1;
        }
        return node1;
    }
}
