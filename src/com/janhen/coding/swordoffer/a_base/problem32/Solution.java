package com.janhen.swordoffer.a_base.problem32;

import com.janhen.swordoffer.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt -- > 0) {
                TreeNode cur = queue.poll();
                if (cur == null) continue;
                res.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return res;
    }
}
