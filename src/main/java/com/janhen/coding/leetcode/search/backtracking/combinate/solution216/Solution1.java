package com.janhen.coding.leetcode.search.backtracking.combinate.solution216;

// 216. Combination Sum III
//https://leetcode.com/problems/combination-sum-iii/
//Medium
// array, backtracking

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution15 set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    private List<List<Integer>> res = new ArrayList<>();

    // 2 ms, faster than 37.95%
    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        int[] record = new int[]{1,2,3,4,5,6,7,8,9};
        backtracking(record, 0, k, n, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] record, int start, int k, int n, List<Integer> list) {
        if (list.size() > k) return;
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;  // note: return
        }
        for (int i = start; i < record.length; i ++) {
            list.add(record[i]);
            backtracking(record, i + 1, k, n - record[i], list);    // start is i+1, not start
            list.remove(list.size() - 1);
        }
    }
}