package com.janhen.coding.leetcode.backtracking.combinate.solution77;

import java.util.ArrayList;
import java.util.List;

class Solution2 {

    private List<List<Integer>> res;

    /* 常见优化思路： 剪枝 */
    // time : O(n^k)
    // space : O(k)
    // [1,2,3,4] 中选取两个元素
    // 3 ms, faster than 93.81%
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n)
            return res;
        backTracking(n, k, 1, new ArrayList<>());
        return res;
    }

    /* 根据情况减少循环的次数 */
    /* 每个节点有几个孩子不确定 */
    private void backTracking(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return ;
        }
        // pruning:  can not get the result
        // 还有k - c.size()个空位, 所以, [i...n] 中至少要有 k - c.size() 个元素
        // note: i最多为 n - (k - c.size()) + 1
        for (int i = start; i <= (n - (k - list.size()) + 1); i ++) {      /* 剪枝优化 */
            list.add(i);
            backTracking(n, k, i + 1, list);       /* 在[i]之前的组合已经尝试过 */
            list.remove(list.size() - 1);
        }
    }
}