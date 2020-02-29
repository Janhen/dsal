package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.sm_matrix_search.solution62;

class SolutionMath {

    // 数学公式求解
    // 本质是组合问题, 机器人共移动  m + n - 1 次
    // 向下移动 m - 1 次
    // ⇒  从 S 中取出 D 个位置的数量,    即为 C(m+n-2, m-1)
    public int uniquePaths(int m, int n) {
        int S = m + n - 2;
        int D = m - 1;
        int res = 1;
        for (int i = 1; i <= D; i ++)
            res = res * (S-D+i) / i;
        return res;
    }
}