package com.janhen.coding.leetcode.algs.search.backtracking.practice.solution93;

import java.util.ArrayList;
import java.util.List;

class Solution1 {

    private final List<String> res = new ArrayList<>();

    //  2 ms, faster than 91.79%
    //21.1 MB, less than 100.00%
    public List<String> restoreIpAddresses(String s) {
        res.clear();
        backtracking(s, 0, 0, new StringBuilder());
        return res;
    }

    /* 三种可能的结果, 每次都从不同处截取, 三次回溯 */
    private void backtracking(String s, int bit, int start, StringBuilder sb) {
        if (s.length() - start > (4 - bit) * 3 || s.length() - start < 4 - bit)    /* 剪枝加速 */
            return;
        if (bit == 3) {
            String cur = s.substring(start);
            if (isValid(cur)) {        /* 终止正确时判断是否加入 */
                res.add(sb.append(cur).toString());
                sb.delete(sb.length() - cur.length(), sb.length());        /* note: 加入之后, 回退 */
                return;
            } else {
                return;
            }
        }
        String val = s.substring(start, Math.min(start + 1, s.length()));
        if (isValid(val)) {
            backtracking(s, bit + 1, start + 1, sb.append(s.charAt(start)).append("."));
            sb.delete(sb.length() - val.length() - 1, sb.length());
        }

        val = s.substring(start, Math.min(start + 2, s.length()));
        if (isValid(val)) {
            backtracking(s, bit + 1, start + 2, sb.append(val).append("."));
            sb.delete(sb.length() - val.length() - 1, sb.length());
        }

        val = s.substring(start, Math.min(start + 3, s.length()));
        if (isValid(val)) {
            backtracking(s, bit + 1, start + 3, sb.append(val).append("."));
            sb.delete(sb.length() - val.length() - 1, sb.length());
        }
    }

    private boolean isValid(String str) {
        return str.length() <= 3 && str.length() > 0 &&
          ((str.length() <= 1 || str.charAt(0) != '0') &&
            Integer.parseInt(str) <= 255);
    }
}