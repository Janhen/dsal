package com.janhen.coding.leetcode.array.binarysearch.solution378;

/*
 * 3 ms, faster than 71.63%
 * We are done here, but let's think about this recursiont_dp in another way:
The key point for any binary search is to figure out the "Search Space". For me, I think there are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number). Most usually, when the array is sorted in one direction, we can use index as "search space", when the array is unsorted and we are going to find a specific number, we can use "range".

Let me give you two examples of these two "search space"

index -- A bunch of examples -- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ ( the array is sorted)
range -- https://leetcode.com/problems/find-the-duplicate-number/ (Unsorted Array)
The reason why we did not use index as "search space" for this recursiont_dp is the matrix is sorted in two directions, we can not find a linear way to map the number and its index.
 *
 */
class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m-1][n-1];   // [lo,hi]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int cnt = countOfLessEqual(matrix, mid);
            if (cnt < k) lo = mid + 1;
            else hi = mid - 1;    // cnt=k kth in [lo,mid], and -1 to skip loop
        }
        return lo;
    }

    // <=mid
    private int countOfLessEqual(int[][] matrix, int key) {
        int cnt = 0;
        // iterate from left to right and then from top to bottom
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] <= key) cnt ++;
                else break;      // note: use sorted property
            }
        }
        return cnt;
    }
}