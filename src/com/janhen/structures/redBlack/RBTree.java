package com.janhen.structures.redBlack;

public class RBTree<K extends Comparable<K>, V>{

    private Node root;
    private int N;

    public RBTree() {
        root = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private boolean isRed(Node node) {
        if (node == null)
            return BLACK;
        return node.color == RED;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node){

        Node x = node.right;

        // 左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node){

        Node x = node.left;

        // 右旋转
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    // 颜色翻转
    private void flipColors(Node node){

        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }


    public void add(K key, V val) {
        root = add(root, key, val);
        root.color = BLACK;  // keep root as a black node
    }

    private Node add(Node node, K key, V value){

        if(node == null){
            N ++;
            return new Node(key, value); // 默认插入红色节点
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.val = value;

        if (isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);

        if (isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);

        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }

    private Node getNode(Node node, K key) {

        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return getNode(node.left, key);
        else if (cmp > 0)
            return getNode(node.right, key);
        else // cmp
            return node;
    }

    public boolean contains(K key) {
        // return contains(root, key);
        return getNode(root, key) != null;
    }

    private boolean contains(Node node, K key) {

        if (node == null)
            return false;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return contains(node.left, key);
        else if (cmp > 0)
            return contains(node.right, key);
        else
            return true;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.val;
    }

    public void set(K key, V val) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException();

        node.val = val;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.val;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        else if (cmp > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        else { // cmp == 0
            // include leaf
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
            // have left and right node
            Node successor = minimum(node.right);
            node.key = successor.key;
            node.val = successor.val;
            node.right = remove(node.right, successor.key);
            return node;
        }
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

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

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K    key;
        public V    val;
        public Node left, right;
        public boolean color;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            left = null;
            right = null;
            color = RED;  // ★ 默认 RED 用于与 BLACK 融合
        }
    }
}