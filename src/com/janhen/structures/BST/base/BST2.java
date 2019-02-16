package com.janhen.structures.BST.base;

import java.util.ArrayList;
import java.util.List;

public class BST2<K extends Comparable<K>, V> {

    protected Node root;

    protected class Node {

        K   key;
        V val;
        Node  left;
        Node  right;

        int N;

        Node(K key, V val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }


    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {

        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);

        if (cmp == 0) {
            return x.val;

        } else if (cmp < 0) {
            return get(x.left, key);

        } else {
            return get(x.right, key);

        }
    }


    public void put(K key, V value) {
        root = put(root, key, value);
    }


    private Node put(Node x, K key, V value) {

        if (x == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(x.key);

        if (cmp == 0) {
            x.val = value;

        } else if (cmp < 0) {
            x.left = put(x.left, key, value);

        } else {
            x.right = put(x.right, key, value);
        }

        recalculateSize(x);           /* 每次增删操作进行尺寸维护 */

        return x;
    }


    public K floor(K key) {

        Node x = floor(root, key);

        if (x == null) {
            return null;
        }

        return x.key;
    }


    private Node floor(Node x, K key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }

        Node t = floor(x.right, key);

        return t != null ? t : x;
    }


    public K min() {
        return min(root).key;
    }


    private Node min(Node x) {

        if (x == null) {
            return null;
        }

        if (x.left == null) {
            return x;
        }

        return min(x.left);
    }


    public void deleteMin() {
        root = deleteMin(root);
    }


    public Node deleteMin(Node x) {

        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);

        recalculateSize(x);

        return x;
    }


    public void delete(K key) {
        root = delete(root, key);
    }


    private Node delete(Node x, K key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = delete(x.left, key);

        } else if (cmp > 0) {
            x.right = delete(x.right, key);

        } else {

            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }

            Node t = x;

            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        recalculateSize(x);

        return x;
    }


    public K max() {
        return max(root);
    }


    private K max(Node x) {

        if (x == null) {
            return null;
        }

        if (x.right == null) {
            return x.key;
        }

        return max(x.right);
    }


    public int rank(K key) {
        return rank(key, root);
    }


    private int rank(K key, Node x) {

        if (x == null) {
            return 0;
        }

        int cmp = key.compareTo(x.key);

        if (cmp == 0) {
            return size(x.left);

        } else if (cmp < 0) {
            return rank(key, x.left);

        } else {
            return 1 + size(x.left) + rank(key, x.right);
        }
    }


    public List<K> keys(K l, K h) {
        return keys(root, l, h);
    }


    private List<K> keys(Node x, K l, K h) {

        List<K> list = new ArrayList<>();

        if (x == null) {
            return list;
        }

        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);

        if (cmpL < 0) {
            list.addAll(keys(x.left, l, h));
        }
        if (cmpL <= 0 && cmpH >= 0) {
            list.add(x.key);
        }
        if (cmpH > 0) {
            list.addAll(keys(x.right, l, h));
        }
        return list;
    }


    protected void recalculateSize(Node x) {
        x.N = size(x.left) + size(x.right) + 1;
    }
}