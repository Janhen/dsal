package com.janhen.structures.segmenttree;

/**
 * 分段树
 *
 * @param <E>
 */
public class SegmentTree<E> {

    private final E[] data;
    private final E[] tree;
    private final Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < data.length; i++)
            data[i] = arr[i];
        tree = (E[]) new Object[data.length * 4];
        buildSegmentTree(0, 0, data.length - 1);
    }

    // Macro sematic : 在 treeIndex 创建 section [l...r] 的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        // bussiness decide
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E query(int queryL, int queryR) {

        if (queryL < 0 || queryL > data.length || queryR < 0 || queryR > data.length)
            throw new IllegalArgumentException();

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // Macro sematic : 在以 treeIndex 为 根的线段树中 [l...r] 的范围内，搜索区间 [queryL, queryR] 的值
    // also can encapsulation a obj that treeIndex, data right and left index
    // - 完全落入右孩子
    // - 完全落入左孩子
    // - 一部分在左孩子，一部分在右孩子 : 分隔 ， 融合
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;

        if (queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    public void set(int index, E e) {

        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException();

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    // 每一层更新一个值
    // time:O(logN)
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // to insure search path
        if (index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else // (index <= mid)
            set(leftTreeIndex, l, mid, index, e);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int size() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException();
        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                sb.append(tree[i]);
            else
                sb.append("null");

            if (i != tree.length - 1)
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
