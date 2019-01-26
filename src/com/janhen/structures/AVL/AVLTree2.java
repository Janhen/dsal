package com.janhen.structures.AVL;

public class AVLTree2<K extends Comparable<K>, V>  {

    protected Node root;
    protected int N;

    public AVLTree2() {
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

    // maintain height and balanceFactor
    // 返回平衡的二叉树根节点
    private Node add(Node node, K key, V val) {

        if (node == null) {
            Node newNode = new Node(key, val);
            N ++;
            return newNode;
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.val = val;
        }
        else if (cmp < 0) {
            node.left = add(node.left, key, val);
        }
        else {
            node.right = add(node.right, key, val);
        }

        // ★ update height   : post traversal
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);

        // not balance and tilt to the left
        // right rolation
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {  // LL
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) { // RR
            return leftRotate(node);
        }
        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 处理 LL
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x    维护 height to calculate balance factor
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    // ★ satisfy BST and balanced
    private Node rightRotate(Node y) {

        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;

        // end BST satisfy

        // ★ maintain height, first calculate y → second x
        y.height = 1 + Math.max(getHeight(T3), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(y));

        // end balanced satisfy
        return x;
    }

    // 处理 RR
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {

        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = 1 + Math.max(getHeight(T2), getHeight(y.left));
        x.height = 1 + Math.max(getHeight(y), getHeight(x.right)) ;
        return x;
    }

    //      y                             y
    //     / \                           / \                             z
    //    x   T4  向左旋转 (x)           z   T4   向左旋转 (y)          /   \
    //   / \     - - - - - - - ->      / \      - - - - - - - ->      x     y
    // T1   z                        x   T3                          / \   / \
    //     / \                      / \                            T1  T2 T3 T4
    //   T2   T3                  T1   T2
    private Node LR(Node y) {
        Node x = y.left;
        y.left = leftRotate(x);
        return rightRotate(y);
    }

    //    y                          y                                    x
    //  /  \                       /  \                                 /   \
    // T1   x      向右旋转 (x)    T1   z        向右旋转 (y)            y     z
    //     / \   - - - - - - - ->     / \     - - - - - - - ->        / \   / \
    //    z  T4                     T2  x                            T1 T2 T3 T4
    //   / \                           / \
    //  T2 T3                         T3 T4
    private Node RL(Node y) {
        Node x = y.right;
        y.right = rightRotate(x);
        return leftRotate(y);
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
        return getNode(root, key) != null;
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
        else { // cmp == 0
            // include leaf
            // have left and right node
            // - mutex execute : becatus use retNode to receive result
            // - modify removeMin
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
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }


        // ST2 : keep balance by retNode
        if (retNode == null)
            return null;

        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        int balanceFactor = getBalanceFactor(retNode);
        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
            return leftRotate(retNode);
        // LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        // RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    /*private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            N --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }*/

    protected class Node {
        public K    key;
        public V    val;
        public Node left, right;
        public int height;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            left = null;
            right = null;
            height = 1;
        }
    }
}
