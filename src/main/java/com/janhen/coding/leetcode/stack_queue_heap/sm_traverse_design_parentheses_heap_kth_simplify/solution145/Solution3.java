package main.java.janhen.leetcode.stack_queue_heap.sm_traverse_design_parentheses_heap_kth_simplify.solution145;

import main.java.janhen.leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution3 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                // findRightMost(cur.left) or can backtracking
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    printEdge(cur1.left, res);     // second cur1 visit
                }
            }
            cur1 = cur1.right;
        }
        printEdge(root, res);    // last root -> rightest
        return res;
    }

    public static void printEdge(TreeNode node, List<Integer> list) {
        TreeNode tail = reverseEdge(node);
        TreeNode cur = tail;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    // ↘  ⇒  ↖
    public static TreeNode reverseEdge(TreeNode node) {
        TreeNode pre = null;
        TreeNode next = null;
        while (node != null) {
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}

