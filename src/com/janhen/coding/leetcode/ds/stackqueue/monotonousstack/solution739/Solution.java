package com.janhen.coding.leetcode.ds.stackqueue.monotonousstack.solution739;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> idxStack = new Stack<>();  // store index
        int[] dist = new int[T.length];     // distance
        for (int i = 0; i < T.length; i++) {
            while (!idxStack.isEmpty() && T[i] > T[idxStack.peek()]) {
                int preIndex = idxStack.pop();     // 比当前值小的向右最近的元素索引
                dist[preIndex] = i - preIndex;
            }
            idxStack.push(i);
        }
        return dist;
    }
}