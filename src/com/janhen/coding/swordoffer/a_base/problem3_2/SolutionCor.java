package com.janhen.swordoffer.a_base.problem3_2;

// time:O(N) space:O(N)
public class SolutionCor {
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
