package com.janhen.coding.leetcode.backtracking.permutate.solution46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SolutionCor {

    int[] aux;

    public List<List<Integer>> permute(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        aux = new int[k];
        backTracking(nums, k, 0, res);
        return res;
    }
 
    private void backTracking(int[] nums, int k, int start, List<List<Integer>> res) {
        if (start == k) {
            res.add(Arrays.stream(aux).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            aux[start] = nums[i];
            backTracking(nums, k, start + 1, res);
        }
    }

    private static void swap(int[] a, int i, int j) {
        if (i == j)
            return;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        System.out.println((new SolutionCor()).permute(new int[]{0,1,2,3,4,5,6,7,8,9}, 3));
    }
}