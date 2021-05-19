package com.janhen.coding.swordoffer.a_base.problem5_2;

public class Solution {
    // 从后向前进行更新
    public void merge(int[] A, int[] B, int lastA, int lastB) {
        int i = lastA - 1;
        int j = lastB - 1;
        int merge = lastA + lastB - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] <= B[j]) {
                A[merge--] = B[j--];
            } else {
                A[merge--] = A[i--];
            }
        }
        while (j >= 0) {
            A[merge--] = B[j--];
        }
    }
}
