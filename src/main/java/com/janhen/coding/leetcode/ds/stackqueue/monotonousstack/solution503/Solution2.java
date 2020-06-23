package com.janhen.coding.leetcode.ds.stackqueue.monotonousstack.solution503;

import java.util.Arrays;
import java.util.Stack;

class Solution2 {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        nums = geneNewNums(nums);
        Stack<Integer> idxStack = new Stack<>();    // index
        int[] nexts = new int[N * 2];    // next
        Arrays.fill(nexts, -1);
        for (int i = 0; i < nums.length; i++) {    // 2N use for mocking loop
            while (!idxStack.isEmpty() && nums[i] > nums[idxStack.peek()]) {
                nexts[idxStack.pop()] = nums[i];
            }
            idxStack.push(i);
        }
        return Arrays.copyOfRange(nexts, 0, N);
    }

    private int[] geneNewNums(int[] nums) {
        int[] newNums = new int[nums.length * 2];
        int k = 0;
        for (int i = 0; i < nums.length; i ++) {
            newNums[k ++] = nums[i];
        }
        for (int i = 0; i < nums.length; i ++) {
            newNums[k ++] = nums[i];
        }
        return newNums;
    }
}