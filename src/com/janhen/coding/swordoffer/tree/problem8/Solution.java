package com.janhen.coding.swordoffer.tree.problem8;

import com.janhen.coding.swordoffer.structures.TreeLinkNode;

/**
 * {@link java.util.TreeMap#successor}
 */
public class Solution {
    // LDR
    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }
        // LDR, now try find in right tree, find leftmost in right tree
        if (node.right != null) {
            TreeLinkNode cur = node.right;
            while (cur.left != null) {          // find leftmost(node.right)
                cur = cur.left;
            }
            return cur;
        } else {                                // find cur is parent left, then return parent
            TreeLinkNode parent = node.next;
            TreeLinkNode cur = node;
            while (parent != null && cur == parent.right) {
                cur = parent;
                parent = parent.next;
            }
            return parent;
        }
    }
}
