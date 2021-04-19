package com.janhen.coding.leetcode.ds.string.solution696;

/*
 * 0001100
 *   01           preLen:3,curLen=1
 *  0011          preLen:3,curLen=2
 *     10         preLen:2,curLen=1
 *    1100        preLen:2,curLen=2
 */
class Solution {
    public int countBinarySubstrings(String s) {
        // 记录连续的 0 / 1 的个数
        // 将字符串 s 按照 0 和 1 的连续段分组
        // s = 00111011s=00111011  ==> counts={2,3,1,2}

        int preLen = 0;
        int curLen = 1;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) {
                res++;
            }
        }
        return res;
    }
}