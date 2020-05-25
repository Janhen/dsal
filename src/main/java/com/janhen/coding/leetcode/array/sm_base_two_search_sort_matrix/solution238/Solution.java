package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution238;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        Arrays.fill(product, 1);

        // record product when iteration
        int left = 1;
        for (int i = 1; i < n; i ++) {
            left *= nums[i-1];
            product[i] = left;
        }

        int right = 1;
        for (int i = n-2; i >= 0; i --) {    // From [n-1] begin *
            right *= nums[i+1];
            product[i] *= right;            // left*right
        }
        return product;
    }
}