package main.java.janhen.swordoffer.tree.problem8;

// 08 二叉树的下一个节点

import main.java.janhen.swordoffer.structures.TreeLinkNode;

public class Solution2 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}
