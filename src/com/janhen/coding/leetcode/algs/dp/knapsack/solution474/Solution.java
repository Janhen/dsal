package com.janhen.coding.leetcode.algs.dp.knapsack.solution474;


import com.janhen.TestUtil;

class Solution {
    // todo error
    public int findMaxForm(String[] strs, int m, int n) {        /* 统计最大个数问题， 在所有中选择最大 */
        if (m == 0 && n == 0)
            return -1;
        int res = 0;
        for (int i = 0; i < strs.length; i ++) {
            int cnt1 = Integer.bitCount(Integer.valueOf(strs[i], 2));
            int cnt0 = strs[i].length() - cnt1;
            if (m-cnt1 >=0 && n-cnt0 >=0) {
                res = Math.max(res, 1 + findMaxForm(strs, m-cnt0, n-cnt1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println((new SolutionDp2()).findMaxForm("", , ));
        String[] strs = new String[]{"10","0001","111001","1","0"};
        for (int i = 0; i < strs.length; i ++) {
            int cnt1 = Integer.bitCount(Integer.valueOf(strs[i], 2));
            int cnt0 = strs[i].length() - cnt1;
            TestUtil.printf("字符: %s, 1 个数: %d, 0 个数: %d", strs[i], cnt1, cnt0);
        }
    }
}