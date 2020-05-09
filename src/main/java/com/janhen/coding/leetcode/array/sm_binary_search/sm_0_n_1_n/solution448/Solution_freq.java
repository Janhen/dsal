package com.janhen.coding.leetcode.array.sm_binary_search.sm_0_n_1_n.solution448;

// 448. Find All Numbers Disappeared in an Array
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// easy
// array

/*
找出∀丟失元素
元素值[1,n]
*/

import java.util.ArrayList;
import java.util.List;

class Solution_freq {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] freqs = new int[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        for (int num : nums)
            freqs[num] ++;

        for (int i = 1; i <= nums.length; i ++)
            if (freqs[i] == 0)
                res.add(i);
        return res;
    }
}