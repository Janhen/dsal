package com.janhen.structures.AVL;

import java.util.NoSuchElementException;

public class AVLTree<K extends Comparable<K>, V>  {

    protected Node root;
    protected int N;

    public AVLTree() {
        root = null;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    protected int getBalanceFactor(Node node) {
        if (node == null)
            return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(K key, V val) {
        root = add(root, key, val);
    }

    private Node add(Node node, K key, V val) {
        if (node == null) {
            N ++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0)               // cover
            node.val = val;
        else if (cmp < 0)
            node.left = add(node.left, key, val);
        else
            node.right = add(node.right, key, val);

        recomputeHeight(node);
        return reBalance(node);
    }

    // ordered AND balanced adjust

    /**
     *  处理 LL -> right rotate
     *  对节点y进行向右旋转操作，返回旋转后新的根节点x    维护 height to calculate balance factor
     *         y                              x
     *        / \                           /   \
     *       x   T4     向右旋转 (y)        z     y
     *      / \       - - - - - - - ->    / \   / \
     *     z   T3                       T1  T2 T3 T4
     *    / \
     *  T1   T2
     *  satisfy BST and balanced
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;      // ordered
        // maintain height, sub tree -> big tree ⇒ first calculate y → second x
        y.height = 1 + Math.max(getHeight(T3), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(y));              // balanced
        return x;
    }

    /**
     * 处理 RR
     * 对节点y进行向左旋转操作，返回旋转后新的根节点x
     *    y                             x
     *  /  \                          /   \
     * T1   x      向左旋转 (y)       y     z
     *     / \   - - - - - - - ->   / \   / \
     *   T2  z                     T1 T2 T3 T4
     *      / \
     *     T3 T4
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;        // ordered

        y.height = 1 + Math.max(getHeight(T2), getHeight(y.left));
        x.height = 1 + Math.max(getHeight(y), getHeight(x.right));           // balanced
        return x;
    }

    /**
     *       y                             y
     *      / \                           / \                             z
     *     x   T4  向左旋转 (x)           z   T4   向左旋转 (y)          /   \
     *    / \     - - - - - - - ->      / \      - - - - - - - ->      x     y
     *  T1   z                        x   T3                          / \   / \
     *      / \                      / \                            T1  T2 T3 T4
     *    T2   T3                  T1   T2
     */
    private Node LR(Node y) {
        Node x = y.left;
        y.left = leftRotate(x);
        return rightRotate(y);
    }

    /**
    *    y                          y                                    x
    *  /  \                       /  \                                 /   \
    * T1   x      向右旋转 (x)    T1   z        向右旋转 (y)            y     z
    *     / \   - - - - - - - ->     / \     - - - - - - - ->        / \   / \
    *    z  T4                     T2  x                            T1 T2 T3 T4
    *   / \                           / \
    *  T2 T3                         T3 T4
    */
    private Node RL(Node y) {
        Node x = y.right;
        y.right = rightRotate(x);
        return leftRotate(y);
    }

    private void recomputeHeight(Node node) {
        if (node == null)
            return;
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * 判断当前平衡性
     * LL: cur.balanceFactor >=2, cur.left.balanceFactor>=0  ⇒ left tree more height,
     * RR:
     * LR:
     * RL:
     */
    private Node reBalance(Node node) {
        if (node == null)
            return null;
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0)
            return LR(node);
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0)
            return RL(node);
        return node;       // balanced
    }

    // query

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.val;
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return getNode(node.left, key);
        else if (cmp > 0)
            return getNode(node.right, key);
        else
            return node;
    }

    // modify

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
            N --;
            return node.val;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        // ST1 : delete node
        Node retNode;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
            retNode =  node;
        }
        else if (cmp > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        }
        else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                N --;
                retNode =  rightNode;
            }
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                N --;
                retNode =  leftNode;
            }
            else {
                // notice right tree joint
                Node successor = minimum(node.right);
                node.key = successor.key;
                node.val = successor.val;
                node.right = remove(node.right, successor.key);
                retNode = node;
            }
        }

        recomputeHeight(retNode);
        return reBalance(retNode);
    }

    // ordered

    public V minimum() {
        if (isEmpty())
            throw new NoSuchElementException();
        return minimum(root).val;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    public V maximum() {
        return maximum(root).val;
    }

    private Node maximum(Node node) {
        while (node.right != null)
            node = node.right;
        return node;
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

    public V removeMin() {
        Node oldMinNode = minimum(root);
        if (oldMinNode != null) {
            root = removeMin(root);
            return oldMinNode.val;
        }
        return null;
    }

    public V removeMax() {
        Node oldMaxNode = maximum(root);
        if (oldMaxNode != null) {
            root = removeMax(root);
            return oldMaxNode.val;
        }
        return null;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            N --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    protected class Node {
        public K    key;
        public V    val;
        public Node left, right;
        public int height;            // height to maintain balanced, every add OR delete to change

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            left = null;
            right = null;
            height = 1;
        }
    }
}
