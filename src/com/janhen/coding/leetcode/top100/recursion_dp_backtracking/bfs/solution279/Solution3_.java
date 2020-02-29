package com.janhen.leetcode.top100.recursion_dp_backtracking.bfs.solution279;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution3_ {
    //  30 ms, faster than 63.18%
    // 进一步优化
    // time: O(n)
    // space: O(n)
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> front = q.poll();
            int num = front.getKey();
            int step = front.getValue();
            for (int i = 1; ; i ++) {
                int a = num - i * i;
                if (a < 0) break;
                if (a == 0) return step + 1;
                if (!visited[a]) {
                    q.offer(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        throw new IllegalArgumentException("no");
    }

    public static void main(String[] args) {

        System.out.println((new Solution3_()).numSquares(12));
        System.out.println((new Solution3_()).numSquares(13));
    }


}