package main.java.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution88;

class SolutionRef {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int merge = m + n - 1;
        while (i >= 0 && j >= 0)
            nums1[merge --] = nums1[i] < nums2[j] ? nums2[j --] : nums1[i --];
        while (j >= 0)
            nums1[merge --] = nums2[j --];
    }
}