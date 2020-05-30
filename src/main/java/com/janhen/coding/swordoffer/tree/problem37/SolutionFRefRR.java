package com.janhen.coding.swordoffer.tree.problem37;

import com.janhen.coding.util.TestUtil;
import com.janhen.coding.swordoffer.structures.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionFRefRR {
    // 8 6 6 6 6 6 # 6 # # # # # # #
    // 最后一层节点使用 #
    // 8 6 6 6 6 6 # 6 # # # # # # #
    // 最后一层节点使用 #
    String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("# ");          // need to record null
                continue;
            }
            sb.append(cur.val + " ");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] vals = str.split(" ");
        int index = 0;                     // record to serialized val
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = geneTreeNode(vals[index ++]);      // geneTreeNode from given value
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) continue;
            cur.left = geneTreeNode(vals[index ++]);            // must generate first THEN offer to queue for iteration
            cur.right = geneTreeNode(vals[index ++]);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return root;
    }

    TreeNode geneTreeNode(String val) {
        if (val.equals("#"))
            return null;
        return new TreeNode(Integer.parseInt(val));      // only Integer can as value
    }

    @Test
    public void des() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(6);
        root.left.left.left =  new TreeNode(6);
        String serializeStr;
        // 8 6 6 6 6 6 # 6 # # # # # # #
        System.out.println( serializeStr = Serialize(root));
        TestUtil.printTree(Deserialize(serializeStr));
    }
}