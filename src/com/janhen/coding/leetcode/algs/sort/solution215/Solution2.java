package com.janhen.coding.leetcode.algs.sort.solution215;

import java.util.PriorityQueue;

class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() == k + 1)
                pq.poll();
        }
        return pq.peek();
    }
}