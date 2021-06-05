package com.janhen.coding.leetcode.algs.search.backtracking.practice.solution93;

import java.util.ArrayList;
import java.util.List;

// bit 控制当前, start 表示从何处开始进行之后的分割, bit 记录当前已经分割了几部分.
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtracking(s, 0, 0, "", res);
        return res;
    }

    private void backtracking(String s, int bit, int start, String tmp, List<String> res) {
        if (s.length() - start > (4 - bit) * 3 || s.length() - start < 4 - bit)    /* 控制起始索引与当前位进行加速, 剪枝加速 */
            return;
        if (bit == 3) {       // already have xx.xx.xx.xx
            String cur = s.substring(start);
            if (isValid(cur)) {
                res.add(tmp + cur);
                return;
            } else {
                return;
            }
        }
        String val = "";                                                    /* 手动控制三种可能性 */
        backtracking(s, bit + 1, start + 1, tmp + s.charAt(start) + ".", res);

        val = s.substring(start, Math.min(start + 2, s.length()));
        if (isValid(val))
            backtracking(s, bit + 1, start + 2, tmp + val + ".", res);

        val = s.substring(start, Math.min(start + 3, s.length()));
        if (isValid(val))
            backtracking(s, bit + 1, start + 3, tmp + val + ".", res);
    }

    private boolean isValid(String str) {
        return str.length() <= 3 && str.length() > 0 &&
          ((str.length() <= 1 || str.charAt(0) != '0') &&    /* 对两位数和三位数首字符不应该为0 */
            Integer.parseInt(str) <= 255);
    }
}