package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class SolutionB {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++)
                pq.offer(new Tuple(nums1[i], nums2[j]));
        }

        while (k-- > 0)
            if (!pq.isEmpty())
                res.add(new int[]{pq.peek().val1, pq.poll().val2});
        return res;
    }

    public class Tuple implements Comparable<Tuple> {
        int val1, val2;
        int sum;

        public Tuple(int x, int y) {
            this.val1 = x;
            this.val2 = y;
            this.sum = x + y;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.sum - that.sum;
        }
    }
}