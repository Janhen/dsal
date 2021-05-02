package com.janhen.coding.swordoffer.a_base.problem32;

import com.janhen.coding.swordoffer.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    // tree level traverse
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                continue;
            }
            res.add(cur.val);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return res;
    }
}
