package com.janhen.coding.leetcode.ds.stackqueue.monotonousstack.solution503;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        // record array index
        Stack<Integer> idxStack = new Stack<>();    // index
        int[] nexts = new int[N];    // next
        Arrays.fill(nexts, -1);
        for (int i = 0; i < 2 * N; i++) {    // 2N use for mocking loop
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