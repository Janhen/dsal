package com.janhen.coding.util;

import com.janhen.coding.leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNodeHelper {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && cur.val < pre.val) {
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

    public static boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {  // strict define
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        // judge in left and right tree
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }

    // node all count
    public static int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }

    public static boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

    /**
     * 二叉树的最小深度
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return 1 + Math.min(left, right);
    }

    /**
     * 根据数组构造二叉树
     */
    public static TreeNode buildBSTFromArray(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBSTFromArray(nums, l, mid - 1);
        root.right = buildBSTFromArray(nums, mid + 1, r);
        return root;
    }

    public int leftSideDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    public int rightSideDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }

    // traverse
    public void preOrder(TreeNode root) {
        TreeNode cur = root;
        if (cur == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    public void inOrder(TreeNode root) {
        TreeNode cur = root;
        if (cur == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // LDR
            cur = stack.pop();
            System.out.print(cur.val + " ");

            cur = cur.right;
        }
        System.out.println();
    }

    public void postOrder(TreeNode root) {
        TreeNode cur = root;
        if (cur == null) {
            return;
        }
        System.out.print("POST : ");

        // DRL to push treeNode
        Stack<TreeNode> stack1 = new Stack<>();
        // record reversed post order value
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(cur);
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            stack2.push(cur.val);

            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
        }
        // LRD
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }
        System.out.println();
    }

    public void levelOrder(TreeNode root) {
        TreeNode cur = root;
        if (cur == null) {
            return;
        }
        System.out.println("LEVEL : ");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                cur = queue.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            System.out.println();
        }
    }

    private int getMaxDuplicationPathLength(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftLen = getMaxDuplicationPathLength(node.left);
        int rightLen = getMaxDuplicationPathLength(node.right);

        int left = (node.left != null && node.left.val == node.val ? leftLen + 1 : 0);
        int right = (node.right != null && node.right.val == node.val ? rightLen + 1 : 0);

        return Math.max(left, right);
    }

    /**
     * 二叉树的最大深度(高度)
     */
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }
}
