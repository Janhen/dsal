package com.janhen.coding.leetcode.stack_queue_heap.sm_nested_ugly_diff_polish_decode_next.solution503;

import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        Stack<Integer> idxStack = new Stack<>();    // index
        int[] nexts = new int[N];    // next
        Arrays.fill(nexts, -1);
        for (int i = 0; i < 2 * N; i ++) {    // 2N use for mocking loop
            int num = nums[i % N];
            while (!idxStack.isEmpty() && num > nums[idxStack.peek()]) {
                nexts[idxStack.pop()] = num;
            }
            if (i < N)    // use for store {0, N-1}
                idxStack.push(i);
        }
        return nexts;
    }
}