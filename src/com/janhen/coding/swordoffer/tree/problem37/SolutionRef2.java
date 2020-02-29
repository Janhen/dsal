package com.janhen.swordoffer.tree.problem37;

// 37 序列化二叉树

import com.janhen.swordoffer.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionRef2 {
    // todo [2,3,3,3,,4,4,#,#,3] 实现
    String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] vals = str.split(" ");
        int index = 0;
        TreeNode root = geneNode(vals[index ++]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        return root;
    }

    private TreeNode geneNode(String val) {
        if (val == "#")
            return null;
        return new TreeNode(Integer.valueOf(val));
    }
}