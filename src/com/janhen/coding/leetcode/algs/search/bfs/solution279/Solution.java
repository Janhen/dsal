package com.janhen.coding.leetcode.algs.search.bfs.solution279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int numSquares(int n) {
        List<Integer> squares = geneSquares(n);
        int pathLen = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            pathLen++;
            int cnt = queue.size();
            while (cnt-- > 0) {
                int cur = queue.poll();
                for (Integer square : squares) {
                    int next = cur - square;
                    if (next < 0)                      // next square can not meet condition
                        break;
                    if (next == 0)
                        return pathLen;
                    if (visited[next])                   // skip already visit
                        continue;
                    visited[next] = true;
                    queue.offer(next);              // traverse next node
                }
            }
        }
        return n;    // 1,1,1,1
    }

    private List<Integer> geneSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int num = 0;
        int diff = 1;
        while (num <= n) {
            num = num + diff;
            diff += 2;
            list.add(num);
        }
        return list;
    }
}
