package com.janhen.coding.leetcode.search.bfs.solution279;


import javafx.util.Pair;

import java.util.LinkedList;

class Solution3 {

    // 18 ms, faster than 95.96%
    // 27.5 MB, less than 17.16%
    public int numSquares(int n) {
        if (n == 0)
            return 0;
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();
            if (num == 0)
                return step;
            for (int i = 1; num - i * i >= 0; i++) {
                int a = num - i * i;
                if (!visited[a]) {
                    if (a == 0) return step + 1;              /* 提前跳出循环 */
                    queue.addLast(new Pair(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        throw new IllegalStateException("No SolutionVIO_$.");
    }

    public static void main(String[] args) {

        System.out.println((new Solution3()).numSquares(12));
        System.out.println((new Solution3()).numSquares(13));
    }
}
