package com.janhen.leetcode.stack_queue_heap.sm_traverse_design_parentheses_heap_kth_simplify.solution373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.val, o2.val));
        int len1 = nums1.length, len2 = nums2.length;
        for (int i = 0; i < len2; i ++)                          // include minimum
            pq.offer(new Tuple(0, i, nums1[0] + nums2[i]));

        for (int i = 0; i < Math.min(k, len1 * len2); i ++) {          // k may too big，  collect result
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.x], nums2[t.y]});
            if (t.x == len1 - 1) continue;
            pq.offer(new Tuple(t.x+1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return res;
    }

    public class Tuple {
        int x, y;
        int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}