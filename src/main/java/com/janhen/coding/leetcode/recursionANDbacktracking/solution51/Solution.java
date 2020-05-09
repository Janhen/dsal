package com.janhen.coding.leetcode.recursionANDbacktracking.solution51;

//51. N-Queens
//        https://leetcode.com/problems/n-queens/description/
// N 皇后问题

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * ERROR
 */
class Solution {
    private List<List<String>> res;

    // keep col that whether or not can access
    private boolean[] col;
    private boolean[] diagonal1;
    private boolean[] diagonal2;


    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        diagonal1 = new boolean[2 * n - 1];
        diagonal2 = new boolean[2 * n - 1];
        putQueen(n, 0, new ArrayList<>());

        return res;
    }


    // List<String> represent a solution15
    // List<Integer> row every element在 [0...n-1] 行对应的列索引放入 Q
    private void putQueen(int n, int index, List<Integer> row) {

        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int j = 0; j < n; j ++) {
            if (!col[j] && !diagonal1[index + 1] &&!diagonal2[index - j + n - 1]) {
                row.add(j);
                col[j] = true;
                diagonal1[index + j] = true;
                diagonal2[index - j + n - 1] = true;

                putQueen(n, index + 1, row);

                col[j] = false;
                diagonal1[index + j] = false;
                diagonal2[index - j + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
        return;
    }

    List<String> generateBoard(int n, List<Integer> row) {
        assert row.size() == n;
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[row.get(i)] = 'Q';
            board.add(new String(chars));
        }
        return board;
    }
}
