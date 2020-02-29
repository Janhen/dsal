package com.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution11;

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (i < j) {
            int curArea = Math.min(height[i], height[j])  * (j - i);
            maxArea = Math.max(maxArea, curArea);
            if (height[i] < height[j])     // skip left part
                i ++;
            else             // skip down part
                j --;
        }
        return maxArea;
    }
}
