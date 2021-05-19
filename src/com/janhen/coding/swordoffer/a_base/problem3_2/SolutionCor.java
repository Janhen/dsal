package com.janhen.coding.swordoffer.a_base.problem3_2;

public class SolutionCor {
    // 更改原始结构找出
    // time:O(N) space:O(N)
    public int findDuplicate(int[] nums) {
        int[] aux = nums.clone();
        for (int i = 0; i < nums.length; i ++) {
            while (aux[i] != i+1) {
                if (aux[i] == aux[aux[i] - 1]) {
                    return aux[i];
                }
                swap(aux, i, aux[i] - 1);
            }
        }
        return -1;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
