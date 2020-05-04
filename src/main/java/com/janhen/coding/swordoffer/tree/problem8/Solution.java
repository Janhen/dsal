package main.java.janhen.swordoffer.tree.problem8;

import main.java.janhen.swordoffer.structures.TreeLinkNode;

/**
 * java.util.TreeMap.successor
 */
public class Solution {
    // LDR
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {          // find leftmost(node.right)
                cur = cur.left;
            }
            return cur;
        }  else {                         // find cur is parent left, then return parent
            TreeLinkNode parent = pNode.next;
            TreeLinkNode cur = pNode;
            while (parent != null && cur == parent.right) {
                cur = parent;
                parent = parent.next;
            }
            return parent;
        }
    }
}
