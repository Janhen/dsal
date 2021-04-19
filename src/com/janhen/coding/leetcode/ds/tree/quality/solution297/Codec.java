package com.janhen.coding.leetcode.ds.tree.quality.solution297;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    private static final String SEPARATOR = " ";
    private static final String NULL = "#";

    // level traverse
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        // queue can storage null node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append(NULL).append(SEPARATOR);
                continue;
            }
            sb.append(cur.val).append(SEPARATOR);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] vals = data.split(SEPARATOR);
        int index = 0;
        TreeNode root = geneTreeNode(vals[index++]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();      // now only one node not have link
            if (cur == null) {
                continue;
            }
            cur.left = geneTreeNode(vals[index++]);
            cur.right = geneTreeNode(vals[index++]);             // link
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return root;
    }

    private TreeNode geneTreeNode(String val) {
        if (val.equals(NULL))                    // handle NULL
            return null;
        return new TreeNode(Integer.parseInt(val));
    }
}