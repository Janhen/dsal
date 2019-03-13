package com.janhen.structures.set_map.set;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

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
    private Node add(Node root, E e) {
        // null also is a binary search tree
        if (root == null) {
            root = new Node(e);
            N ++;
            return root;
        }

        int cmp = e.compareTo(root.val);
        if (cmp > 0)
            // handle the change
            root.right = add(root.right, e);
        else if (cmp < 0)
            root.left = add(root.left, e);

        return root;
    }

    public boolean contains(E e) {
        return contains(root, e);
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

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null)
            return ;

        System.out.print(root.val + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderNR() {
        preOrderNR(root);
    }

    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();

        stack.push(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.val + " ");

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    /*
    traverse not need modify tree structures
    and not use recursion
     */
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


    private void layerOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");

            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
    }

    public void layerOrderLine() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            int layerCnt = queue.size();
            while (layerCnt -- > 0) {
                Node cur = queue.poll();
                System.out.print(cur.val + " ");

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            System.out.println();
        }
    }

    private void layerOrderLine(Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        while (!queue.isEmpty()) {

            int layerCnt = queue.size();
            while (layerCnt -- > 0) {
                Node cur = queue.poll();
                System.out.print(cur.val + " ");

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            System.out.println();
        }
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

    public E minimumNR() {
        if (root == null)
            throw new IllegalArgumentException();

        Node cur = root;
        while (cur.left != null)
            cur = cur.left;
        return cur.val;
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

    public E maximumNR() {
        if (root == null)
            throw new IllegalArgumentException();

        Node cur = root;
        while (cur.right != null)
            cur = cur.right;
        return cur.val;
    }

    /*
    删除 BST min:
        - leaf node
        - not leaf node : let sub right tree as cur location
     */
    public E removeMin() {
        E minVal = minimum();
        root = removeMin(root);
        return minVal;
    }


    /*private void removeMin(Node root) {

        if (root.left == null)
            return;

        if (root.left.left == null)
            root.left = root.left.right;

        removeMin(root.left);
    }*/
    // delete node that is root min
    // and return new root
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            N--;
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

            // not need
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            // N ++;
            successor.left = node.left;

            node.left = node.right = null;
            // N --;
            return successor;
        }
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
