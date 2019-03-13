package com.janhen.structures.BST;

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

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // add

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            N ++;
            return new Node(e);
        }
        int cmp = e.compareTo(node.val);
        if (cmp > 0)
            node.right = add(node.right, e);
        else if (cmp < 0)
            node.left = add(node.left, e);
        return node;
    }

    // query

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

    // order related

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
        root = removeMin(root);       // find node for return then delete node
        return oldMin;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;    // take right sub tree as original position
            node.right = null;           // help to gc
            N --;
            return rightNode;
        }

        node.left = removeMin(node.left);  // alway is left
        return node;
    }

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

        node.right = removeMax(node.right);
        return node;
    }

    // remove

    public void remove(E e) {
        Node deleteNode = getNode(root, e);    // find deleteNode, insure BST have this node
        if (deleteNode != null) {
            root = remove(root, e);
        }
    }

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
            if (node.left == null) {
                Node rightNode = node.right;    // take right sub tree to join
                node.right = null;
                N --;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;      // take left sub tree to join
                node.left = null;
                N --;
                return leftNode;
            }
            Node successor = minimum(node.right);    // take successor to join
            node.val = successor.val;
            node.right = remove(node.right, successor.val);   // reuse function
            return node;
        }
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
