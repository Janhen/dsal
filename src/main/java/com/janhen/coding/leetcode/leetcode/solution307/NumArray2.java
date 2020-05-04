package main.java.janhen.leetcode.leetcode.solution307;

class NumArray2 {

    // only one abstract method can use automatically lambda expression
    private interface Merger<E> {
        E merge(E a, E b);
    }

    private class SegmentTree<E> {

        private E[] data;
        private E[] tree;
        Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {

            this.merger = merger;

            data = arr.clone();

            tree = (E[]) new Object[data.length * 4];
            buildSegmentTree(0, 0, data.length - 1);
        }

        // Macro semantic : 在 treeIndex 创建 section [l...r] 的线段树
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

            if (queryL < 0 || queryL > data.length ||
                    queryR < 0 || queryR > data.length)
                throw new IllegalArgumentException();

            return query(0, 0, data.length - 1, queryL, queryR);
        }

        // Macro sematic : 在以 treeIndex 为 根的线段树中 [l...r] 的范围内，搜索区间 [queryL, queryR] 的值
        // also can encapsulation a obj that treeIndex, data right and left index
        //   - 完全落入右孩子
        //   - 完全落入左孩子
        //   - 一部分在左孩子，一部分在右孩子 : 分隔 ， 融合
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

        // time : O(logn)
        private void set(int treeIndex, int l, int r, int index, E e) {

            if (l == r) {
                tree[treeIndex] = e;
                return;
            }

            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            // update one part every timen
            if (index >= mid + 1)  // only right tree
                set(rightTreeIndex, mid + 1, r, index, e);
            else // (index <= mid)           only left true
                set(leftTreeIndex, l, mid, index, e);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }
    }

    SegmentTree<Integer> segTree;

    // core
    public NumArray2(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < data.length; i ++)
                data[i] = nums[i];

            segTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        if (segTree == null)
            throw new IllegalArgumentException();

        segTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        if (segTree == null)
            throw new IllegalArgumentException();

        return segTree.query(i, j);
    }
}