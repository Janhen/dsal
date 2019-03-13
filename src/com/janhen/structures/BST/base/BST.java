package com.janhen.structures.BST.base;

import com.janhen.structures.BST.IBST;

/**
 * 仅存放值
 */
public class BST<E extends Comparable<E>> implements IBST<E>  {

    private Node root;

    private int  N;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
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
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;        // help to gc
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

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
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
            /*three condtion :
                 - P1: left is null(include leaf)
                 - P2: right is null(include leaf)
                 - P3: left and right not null : 取 min(E)  e.val > [e], 右子树拼接删除该值的根，左子树拼接当前 node 的左子树
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
            // not need maintain size
            Node successor = minimum(node.right);      /* 当前节点含有左右孩子, 找到大于当前节点的最小值 ⇒ 右子树的最左节点 */
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
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
