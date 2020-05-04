package main.java.janhen.swordoffer.a_base.problem32_3;

import main.java.janhen.swordoffer.structures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        boolean needReverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode cur = queue.poll();
                if (cur == null) continue;
                list.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            if (needReverse) Collections.reverse(list);
            if (list.size() != 0) res.add(list);
            needReverse = !needReverse;
        }
        return res;
    }
}
