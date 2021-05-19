package com.janhen.coding.swordoffer.a_base.problem66;

import java.util.Arrays;

public class Solution {
    public int[] multiply(int[] A) {
        int[] product = new int[A.length];
        Arrays.fill(product, 1);
        // fill left half
        int left = 1;
        for (int i = 1; i < A.length; i++) {
            // skip current
            left *= A[i - 1];
            product[i] = left;
        }
        // file right half
        int right = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            // skip current
            right *= A[i + 1];
            product[i] *= right;
        }
        return product;
    }
}
