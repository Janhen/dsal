package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution11;

public class Solution2 {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (i < j) {
            int h = Math.min(height[i], height[j]);          // 当前最短高度
            maxArea = Math.max(maxArea, h * (j - i));
            while (height[i] <= h && i < j) i ++;       // find h>[] element index as window edge,   循环中确定索引
            while (height[j] <= h && i < j) j --;
        }
        return maxArea;
    }
}
