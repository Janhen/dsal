package com.janhen.coding.leetcode.algs.math.solution238;

import java.util.Arrays;

class SolutionF {
  public int[] productExceptSelf(int[] nums) {
      // 1. define and fill initial product
    int n = nums.length;
    int[] product = new int[n];
    Arrays.fill(product, 1);

    // 2. record left product
    int left = 1;
    for (int i = 1; i < n; i++) {
      left *= nums[i - 1];
      product[i] = left;
    }

    // 3. record right product and mul left product to collect result
    int right = 1;
    for (int i = n - 2; i >= 0; i--) {    // From [n-1] begin *
      right *= nums[i + 1];
      product[i] *= right;            // left*right
    }
    return product;
  }
}