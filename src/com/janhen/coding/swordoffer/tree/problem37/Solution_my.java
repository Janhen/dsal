package com.janhen.coding.swordoffer.tree.problem37;

import com.janhen.coding.swordoffer.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_my {
    String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {     // no need level to print
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("# ");       // need seperator to split
                continue;
            } else {
                sb.append(cur.val + " ");
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] vals = str.split(" ");
        int idx = 0;
        TreeNode root = geneTreeNode(vals[idx ++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                continue;
            }
            cur.left =  geneTreeNode(vals[idx ++]);       // NOTE: need to join
            cur.right = geneTreeNode(vals[idx ++]);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return root;
    }

    TreeNode geneTreeNode(String val) {
        if ("#".equals(val)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }
}
