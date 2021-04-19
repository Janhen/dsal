package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // record array border
        int i = m - 1, j = n - 1;
        // set element value from big to small, prevent cover element
        for (int merge = m + n - 1; merge >= 0; merge--) {
            if (i < 0)
                nums1[merge] = nums2[j--];
            else if (j < 0)
                nums1[merge] = nums1[i--];
            else if (nums1[i] > nums2[j])
                nums1[merge] = nums1[i--];    // select big one
            else
                nums1[merge] = nums2[j--];
        }
    }
}
