package com.janhen.coding.swordoffer.tree.problem8;

// 08 二叉树的下一个节点

import com.janhen.coding.swordoffer.structures.TreeLinkNode;

public class Solution2 {

    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node.right != null) {
            TreeLinkNode right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else {
            while (node.next != null) {
                TreeLinkNode parent = node.next;
                if (parent.left == node) {
                    return parent;
                }
                node = node.next;
            }
        }
        return null;
    }
}
