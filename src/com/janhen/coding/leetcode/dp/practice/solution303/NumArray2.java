package com.janhen.leetcode.dp.practice.solution303;

class NumArray2 {

    private interface Merger<E> {
        E merge(E a, E b);
    }

    private class SegmentTree<E> {

        private E[] data;
        private E[] tree;
        Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {

            data = (E[]) new Object[arr.length];
            for (int i = 0; i < data.length; i ++)
                data[i] = arr[i];

            // max size : 4 * size
            // CBT??
            tree = (E[]) new Object[data.length * 4];
            buildSegmentTree(0, 0, data.length - 1);
            this.merger = merger;
        }

        // make sure tree array to save value by original data array
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

        // core logic : different handler
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {

            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            int mid = l + (r - l) / 2;


            if (queryL >= mid + 1)             // must at right part
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            else if (queryR <= mid)           // must at left part
                return query(leftTreeIndex, l, mid, queryL, queryR);


            // have two part
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }
    }


    private SegmentTree<Integer> segTree;

    public NumArray2(int[] nums) {
        if (nums.length > 0) {
            Integer[] arr = new Integer[nums.length];
            for (int i = 0; i < arr.length; i++)
                arr[i] = nums[i];

            segTree = new SegmentTree<>(arr, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        // check
        if (segTree == null)
            throw new IllegalArgumentException();

        return segTree.query(i, j);
    }
}