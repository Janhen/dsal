package com.janhen.coding.leetcode.ds.hashtable.solution447;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // time : O(N^2), space : O(N)
    public int numberOfBoomerangs(int[][] points) {
        int ret = 0;
        // 循环中尽量不创建对象
        // distance -> freq
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dis = distance(point, points[j]);
                    freqs.put(dis, freqs.getOrDefault(dis, 0) + 1);
                }
            }
            for (int dis : freqs.keySet()) {
                if (freqs.get(dis) >= 2) {
                    ret += freqs.get(dis) * (freqs.get(dis) - 1);
                }
            }
            freqs.clear();
        }
        return ret;
    }

    private int distance(int[] A, int[] B) {
        return (A[0] - B[0]) * (A[0] - B[0]) + (A[1] - B[1]) * (A[1] - B[1]);
    }
}
