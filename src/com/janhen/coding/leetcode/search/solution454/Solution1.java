package com.janhen.leetcode.search.solution454;

//454. 4Sum II
//        https://leetcode.com/problems/4sum-ii/description/
// medium
// binary search

// Given four lists A, B, C, D of integer values,
// compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
//
//To make recursiont_dp a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
// All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
//
//Example:
//
//Input:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//Output:
//2
//
//Explanation:
//The two tuples are:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

import java.util.HashMap;
import java.util.Map;

class Solution1 {

    // A[i] + B[j] + C[k] + D[l] = 0
    // ───────────   ───────────
    //     P              P`
    // P + P` = 0                P

    // 98 ms, faster than 80.42%
    // time : O(n^2)
    // space : O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        // 保存 C + D 的可能性
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < C.length; i ++)   // len(C) * len(D)
            for (int j = 0; j < D.length; j ++)
                record.put(C[i] + D[j], record.getOrDefault(C[i] + D[j], 0) + 1);    // frequency record

        int res = 0;
        for (int i = 0; i < A.length; i ++)
            for (int j = 0; j < B.length; j ++)
                if (record.containsKey(0 - A[i] - B[j]))     // corresponding can come to result constraint
                    res += record.get(0 - A[i] - B[j]);

        return res;
    }
}