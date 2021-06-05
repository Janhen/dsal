package com.janhen.coding.leetcode.algs.search.bfs.solution279;

//279. Perfect Squares
//        https://leetcode.com/problems/perfect-squares/description/
// medium  1149:92
// Math, dynamic programming, BFS

/* Given a positive integer n,
 find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

 Memory Limit*/

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

// not through
// todo Q
class SolutionVIO {
    // 该方法会导致 Time Limit Exceeded 或者 Memory Limit Exceeded
    // can use equal num many times
    // time:O(n^2)
    // space:O(n^2)
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(n, 0));
        while (!q.isEmpty()) {
            int num = q.peek().getKey();
            int step = q.poll().getValue();
            if (num == 0)
                return step;
            // 冗余节点
            for (int i = 1; num - i * i >= 0; i++)
                q.offer(new Pair<>(num - i * i, step + 1));
        }
        throw new IllegalArgumentException("no");
    }
}