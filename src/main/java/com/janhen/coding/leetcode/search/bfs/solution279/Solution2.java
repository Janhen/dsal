package com.janhen.coding.leetcode.search.bfs.solution279;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(n, 0));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!q.isEmpty()) {
            int num = q.peek().getKey();
            int step = q.peek().getValue();
            q.poll();
            if (num == 0)
                return step;
            for (int i = 1; num - i * i >= 0; i ++) {
                if (!visited[num - i * i]) {
                    q.offer(new Pair<>(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        throw new IllegalArgumentException("no");
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).numSquares(12));
        System.out.println((new Solution2()).numSquares(13));
    }
}