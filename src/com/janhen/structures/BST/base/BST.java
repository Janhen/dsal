package com.janhen.structures.BST.base;

import com.janhen.structures.BST.IBST;

import java.util.*;

public class BST<E extends Comparable<E>> implements IBST<E>  {

    private Node root;
    private int  N;

    public BST() {
        root = null;  // null is a tree
        N = 0;
    }

    public BST(E [] arr) {
        root = null;
        N = 0;
        for (int i = 0; i < arr.length; i ++)
            add(arr[i]);
    }

    public BST(List<E> list) {
        root = null;
        N = 0;
        for (E val : list)
            add(val);
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // update root reference
    public void add(E e) {
        root = add(root, e);
    }

    // 带节点拼接，不处理 left,right 节点为 null
    // 返回插入新节点后 BST 的根
    private Node add(Node node, E e) {
        // null also is a binary search tree
        if (node == null) {
            node = new Node(e);
            N ++;
            return node;
        }

        int cmp = e.compareTo(node.val);
        if (cmp > 0)
            node.right = add(node.right, e);
        else if (cmp < 0)
            node.left = add(node.left, e);

        return node;
    }

    private Node getNode(Node node, E e) {
        if (node == null)
            return null;
        int cmp = e.compareTo(node.val);
        if (cmp < 0)
            return getNode(node.left, e);
        else if (cmp > 0)
            return getNode(node.right, e);
        else
            return node;
    }

    public boolean contains(E e) {
        return getNode(root, e) != null;
//        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null)
            return false;

        int cmp = e.compareTo(root.val);
        if (cmp == 0)
            return true;
        else if (cmp < 0)
            return contains(root.left, e);
        else
            return contains(root.right, e);
    }

    public E minimum() {
        if (root == null)
            throw new IllegalArgumentException();

        return minimum(root).val;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    public E maximum() {
        if (root == null)
            throw new IllegalArgumentException();

        return minimum(root).val;
    }

    private Node maximum(Node root) {
        if (root.right == null)
            return root;

        return minimum(root.right);
    }

    /*
    删除 BST min:
        - leaf node
        - not leaf node : let sub right tree as cur location
     */
    public E removeMin() {
        E oldMin = minimum();
        root = removeMin(root);
        return oldMin;
    }


    // delete node that is root min
    // and return new root
    // ★
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            N --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E oldMax = maximum();
        root = removeMax(root);
        return oldMax;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            N --;
            return leftNode;
        }

        // 最底层删除，进行上一层(最大节点的父节点)
        node.right = removeMax(node.right);
        return node;
    }


    public void remove(E e) {
        root = remove(root, e);
    }

    // Macro semantic : 删除以 node 为根 BST 中 值为 e 的节点
    // Return : 删除元素后新的 BST 的根
    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        int cmp = e.compareTo(node.val);
        if (cmp < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        else if (cmp > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else {
            /*
            three condtion :
                 - left is null(include leaf)
                 - right is null(include leaf)
                 - left and right not null : 取 min(E)  e.val > [e], 右子树拼接删除该值的根，左子树拼接当前 node 的左子树
              */
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                N --;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                N --;
                return leftNode;
            }

            // ★ not need maintain size
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    public void preOrder() {

        Node cur1 = root;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1)
                    cur2 = cur2.right;

                if (cur2.right == null) {
                    cur2.right = cur1;
                    System.out.print(cur1.val + " ");
                    cur1 = cur1.left;
                    continue;
                } else if (cur2.right == cur1) {
                    cur2.right = null;
                }
            } else {
                System.out.print(cur1.val + " ");
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }

    public void inOrder() {
        Node cur1 = root;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1)
                    cur2 = cur2.right;

                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            System.out.print(cur1.val + " ");
            cur1 = cur1.right;
        }
        System.out.println();
    }

    public void postOrder() {
        Node cur1 = root;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1)
                    cur2 = cur2.right;

                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    printEdge(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        printEdge(root);
    }

    private void printEdge(Node node) {
        Node tail = reverseEdge(node);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private Node reverseEdge(Node node) {
        Node prev = null;
        while (node != null) {
            Node next = node.right;
            node.right = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public void levelOrder() {
        List<E> levelList = new ArrayList<>();
        int level = getDepthAndLevel(root, levelList);
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
    private int getDepthAndLevel(Node root, List<E> list) {
        if (root == null)
            return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int cnt = q.size();
            while (cnt -- > 0) {
                Node node = q.poll();
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

    private String generateEle(E val) {
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

    public void printTree() {
        System.out.println("Binary Tree:");
        printInOrder(root, 0, "H", 17);
        System.out.println();
    }

    // RDL
    private void printInOrder(Node head, int height, String to, int len) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node root, int depth, StringBuilder sb) {

        if (root == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }

        sb.append(generateDepthString(depth) + root.val + "\n");
        generateBSTString(root.left, depth + 1, sb);
        generateBSTString(root.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i ++)
            sb.append("--");
        return sb.toString();
    }

   private class Node {
       public E    val;
       public Node left, right;

       public Node(E e) {
           this.val = e;
           left = null;
           right = null;
       }
   }
}
