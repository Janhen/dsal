package com.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution283;

// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/description/
// easy
// array, tow pointers

import java.util.ArrayList;
import java.util.List;

// time : O(N)
// space : O(N)
class SolutionBa {
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            if (num != 0)
                list.add(num);

        for (int i = 0; i < list.size(); i ++)
            nums[i] = list.get(i);
        for (int i = list.size(); i < nums.length; i ++)
            nums[i] = 0;
    }
}