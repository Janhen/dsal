package com.janhen.coding.swordoffer.tree.problem8;

import com.janhen.coding.swordoffer.structures.TreeLinkNode;

/**
 * TreeMap.predecessor
 */
public class SolutionCor {
    // 找前驱节点
    public TreeLinkNode predecessor(TreeLinkNode node) {
        if (node == null)
            return null;
        if (node.left != null) {
            TreeLinkNode cur = node.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            return cur;
        } else {
            TreeLinkNode parent = node.next;
            TreeLinkNode cur = node;
            while (parent != null && cur == parent.left) {
                cur = parent;
                parent = parent.next;
            }
            return parent;
        }
    }
}
