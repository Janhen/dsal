package com.janhen.leetcode.BT.sm_depth_bst_cbt_b_traverse_ancestor.solution297;

import com.janhen.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    private static final String SEPARATOR = " ";
    private static final String NULL = "#";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append(NULL + SEPARATOR);
                continue;
            }
            sb.append(cur.val + SEPARATOR);
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] vals = data.split(SEPARATOR);
        int index = 0;
        TreeNode root = geneTreeNode(vals[index ++]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();      // now only one node not have link
            if (cur == null) continue;
            cur.left = geneTreeNode(vals[index ++]);
            cur.right = geneTreeNode(vals[index ++]);             // link
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return root;
    }

    private TreeNode geneTreeNode(String val) {
        if (val.equals(NULL))                    // handle NULL
            return null;
        return new TreeNode(Integer.valueOf(val));
    }
}