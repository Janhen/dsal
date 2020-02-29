package com.janhen.swordoffer.a_base.problem32_2;

import com.janhen.swordoffer.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (cnt-- > 0) {
                TreeNode cur = queue.poll();
                if (cur == null) continue;
                list.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            if (!list.isEmpty())                  // Note: Queue 中可存放 null 的处理, 循环中跳过 null; 可能在树的最后一行没有任意一个元素放入到队列中.
                res.add(list);
        }
        return res;
    }
}
