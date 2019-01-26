package com.janhen.structures.BST;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> implements IBST<E> {

    private Node root;
    private int  N;

    public BST() {
        root = null;
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
            // handle the change
            node.right = add(node.right, e);
        else if (cmp < 0)
            node.left = add(node.left, e);

        return node;
    }

    /*public void add(E e) {

        if (root == null) {
            root = new Node(e);
            N ++;
        } else {
            add(root, e);
        }
    }

    // 向 root 为根的 BST 中插入元素 e
    private void add(Node root, E e) {
        // terminal condition
        int cmp = e.compareTo(root.val);
        if (e.equals(root.val))
            return;
        else if (cmp < 0 && root.left == null) {
            root.left = new Node(e);
            N ++;
            return;
        }
        else if (cmp > 0 && root.right == null) {
            root.right = new Node(e);
            N ++;
            return;
        }

        if (cmp < 0)
            add(root.left, e);
        else
            add(root.right, e);
    }*/

    public boolean contains(E e) {
        return getNode(root, e) != null;
    }

    private Node getNode(Node node, E e) {
        if (node == null)
            return null;

        int cmp = e.compareTo(node.val);
        if (cmp == 0)
            return node;
        else if (cmp < 0)
            return getNode(node.left, e);
        else
            return getNode(node.right, e);
    }

    public E minimum() {
        if (root == null)
            throw new IllegalArgumentException();

        return minimum(root).val;
    }

    private Node minimum(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public E maximum() {
        if (root == null)
            throw new IllegalArgumentException();
        return maximum(root).val;
    }

    public Node maximum(Node node) {
        while (node.right != null)
            node = node.right;
        return node;
    }

    public E removeMin() {
        E oldMin = minimum();
        root = removeMin(root);
        return oldMin;
    }

    // delete node that is root min
    // and return new root
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

    /*
    delete BST max:
        - leaf node
        - not leaf node : let sub left tree as cur location
     */

    public E removeMax() {
        E maxVal = maximum();
        root = removeMax(root);
        return maxVal;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            N--;
            return leftNode;
        }

        // 最底层删除，进行上一层(最大节点的父节点)
        node.right = removeMax(node.right);
        return node;
    }


    public void remove(E e) {
        Node deleteNode = getNode(root, e);
        if (deleteNode != null) {
            root = remove(root, e);
        }
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

            // ★ how to maintain N
            Node successor = minimum(node.right);
            node.val = successor.val;
            node.right = remove(node.right, successor.val);
            return node;
        }
    }

    public void preOrder() {
        System.out.print("PreOrder: ");
        Node cur = root;
        Stack<Node> s = new Stack<>();
        s.push(cur);
        while (!s.isEmpty()) {
            cur = s.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null)
                s.push(cur.right);
            if (cur.left != null)
                s.push(cur.left);
        }
        System.out.println();
    }


    public void inOrder() {
        System.out.print("InOrder: ");
        Node cur = root;
        Stack<Node> s = new Stack<>();
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public void postOrder() {
        System.out.print("PostOrder: ");
        Node cur = root;
        Stack<Node> s1 = new Stack<>();
        Stack<E> s2 = new Stack<>();
        s1.push(cur);
        while (!s1.isEmpty()) {
            cur = s1.pop();
            s2.push(cur.val);
            if (cur.left != null)
                s1.push(cur.left);
            if (cur.right != null)
                s1.push(cur.right);
        }
        while (!s2.isEmpty())
            System.out.print(s2.pop() + " ");
        System.out.println();
    }

    public void levelOrder() {
        System.out.print("LevelOrder: ");
        Node cur = root;
        Queue<Node> q = new LinkedList<>();
        q.offer(cur);
        while (!q.isEmpty()) {
            int cnt = q.size();
            while (cnt -- > 0) {
                cur = q.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            System.out.println();
        }
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    // traverse not need modify tree structures
    public void layerOrder() {
        if (root == null)
            return ;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.val + " ");

            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null)
                q.offer(cur.right);
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
