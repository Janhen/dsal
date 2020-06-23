package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution11;

// time:O(N^2) space:O(1)
public class SolutionBF {
    public int maxArea(int[] height) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < height.length; i ++) {
            for (int j = i + 1; j < height.length; j ++) {
                cur = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
