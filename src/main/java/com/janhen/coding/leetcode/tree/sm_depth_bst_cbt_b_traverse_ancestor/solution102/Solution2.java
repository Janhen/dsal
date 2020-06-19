package com.janhen.coding.leetcode.tree.sm_depth_bst_cbt_b_traverse_ancestor.solution102;

import com.janhen.coding.leetcode.structures.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution2 {

    // container have container operation
    // pair:
    //  - key: TreeNode
    //  - val: layer
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));         // level zero a_base, for relate to List<List>
        while (!q.isEmpty()) {
            TreeNode node = q.peek().getKey();
            int level = q.poll().getValue();
            if (level == res.size())                // init container
                res.add(new ArrayList<>());
            res.get(level).add(node.val);        // current level to add element
            if (node.left != null)
                q.offer(new Pair<>(node.left, level + 1));
            if (node.right != null)
                q.offer(new Pair<>(node.right, level + 1));
        }
        return res;
    }
}