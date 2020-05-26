package com.janhen.coding.leetcode.structures;

import java.util.*;

public class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(Integer[] arr) {

        int index = 0;
        TreeNode cur = this;
        cur.val = arr[index ++];    // insure root node

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(cur);
        while (!q.isEmpty()) {
            cur = q.poll();
            cur.left = index < arr.length ? generateNode(arr[index ++]) : null;          // must judge: leaf left and right child not include in arr
            cur.right = index < arr.length ? generateNode(arr[index ++]) : null;
            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null)
                q.offer(cur.right);
        }
    }

    private TreeNode generateNode(Integer val) {
        if (val == null)
            return null;
        return new TreeNode(val);
    }

    public int leftSideDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth ++;
            node = node.left;
        }
        return depth;
    }

    public int rightSideDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth ++;
            node = node.right;
        }
        return depth;
    }

    // traverse
    public void preOrder() {
        TreeNode cur = this;
        if (cur == null) return;
        System.out.print("PRE  : ");

        Stack<TreeNode> s = new Stack<>();
        s.push(cur);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            System.out.print(node.val + " ");
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }
        System.out.println();
    }

    public void inOrder() {
        TreeNode cur = this;
        if (cur == null) return;
        System.out.print("IN   : ");

        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            // LDR
            cur = s.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public void postOrder() {
        TreeNode cur = this;
        if (cur == null) return;
        System.out.print("POST : ");

        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(cur);
        while (!s1.isEmpty()) {
            // DRL
            cur = s1.pop();
            s2.push(cur.val);

            if (cur.left != null)
                s1.push(cur.left);
            if (cur.right != null)
                s1.push(cur.right);
        }
        // LRD
        while (!s2.isEmpty())
            System.out.print(s2.pop() + " ");
        System.out.println();
    }

    public void levelOrder() {
        TreeNode cur = this;
        if (cur == null) return;
        System.out.println("LEVEL : ");

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(cur);
        while (!q.isEmpty()) {
            int cnt = q.size();
            while (cnt -- > 0) {
                cur = q.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            System.out.println();
        }
    }

    public void printTree() {
        System.out.println("Binary Tree:");
        printInOrder(this, 0, "H", 17);
        System.out.println();
    }

    private void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null)
            return;

        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);

        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public void printLevel() {
        List<Integer> levelList = new ArrayList<>();
        int level = getDepthAndLevel(this, levelList);
        boolean[][] positions = getPositions(level);
        System.out.println("Level : " + level);

        int index = 0;
        for (boolean[] position : positions) {
            for (boolean isFill : position) {
                if (isFill)
                    System.out.print(generateEle(levelList.get(index ++)));
                else
                    System.out.print(generateEle(null));
            }
            System.out.println();
        }
    }

    private static boolean[][] getPositions(int level) {
        int cols = (int) Math.pow(2, level - 1) * 2 - 1;
        boolean[][] res = new boolean[level][cols];

        for (int i = level - 1; i >= 0; i --) {
            int cnt = (int) Math.pow(2, i);
            int[] position = new int[cnt];

            int first = (cols / cnt) / 2;
            int gap = first + 1;
            position[0] = first;
            for (int j = 1; j < cnt; j ++)
                position[j] = position[j - 1] + gap * 2;

            int index = 0;
            for (int j = 0; j < cols; j ++) {
                if (index < position.length && j == position[index]) {
                    res[i][j] = true;
                    index ++;
                }
            }
        }
        return res;
    }

    // original level : null as leaf
    // return level : not include null level
    private int getDepthAndLevel(TreeNode root, List<Integer> list) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int cnt = q.size();
            while (cnt -- > 0) {
                TreeNode node = q.poll();
                if (node == null) {
                    list.add(null);
                    continue;
                }
                list.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            level ++;
        }
        level --;
        int allCnt = (int) Math.pow(2, level) - 1;
        while (list.size() <= allCnt)
            list.add(null);
        return level;
    }

    private String generateEle(Integer val) {
        if (val == null)
            return "     ";
        else {
            int len = 5;
            int valLen = String.valueOf(val).length();
            char[] chs = new char[5];

            int index = (len - valLen) / 2;
            for (char c : String.valueOf(val).toCharArray())
                chs[index ++] = c;

            return new String(chs);
        }
    }


    // judge
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;      // record to compare
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (pre != null && cur.val < pre.val) return false;   // compare
            pre = cur;        // update pre as cur
            cur = cur.right;
        }
        return true;
    }

    public static boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)      // strict define
            return false;
        if (t1.val != t2.val)
            return false;
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }

    // query

    // node all count
    public static int count(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + count(node.left) + count(node.right);
    }

    private int getMaxDuplicationPathLength(TreeNode node) {
        if (node == null) return 0;

        int leftLen = getMaxDuplicationPathLength(node.left);
        int rightLen = getMaxDuplicationPathLength(node.right);

        int left = (node.left != null && node.left.val == node.val ? leftLen + 1 : 0);
        int right = (node.right != null && node.right.val == node.val ? rightLen + 1: 0);

        return Math.max(left, right);
    }


    public static boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        return node.left == null && node.right == null;
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0)
            return left + right + 1;
        return 1+ Math.min(left, right);
    }

    public static TreeNode buildBSTFromArray(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBSTFromArray(nums, l, mid-1);
        root.right = buildBSTFromArray(nums, mid + 1, r);
        return root;
    }
}

