package main.java.janhen.swordoffer.a_base.problem66;

import java.util.Arrays;

public class Solution {
    public int[] multiply(int[] A) {
        int[] product = new int[A.length];
        Arrays.fill(product, 1);
        int left = 1;
        for (int i = 1; i < A.length; i ++) {
            left *= A[i-1];
            product[i] = left;
        }
        int right = 1;
        for (int i = A.length - 2; i >= 0; i --) {
            right *= A[i + 1];
            product[i] *= right;
        }
        return product;
    }
}
