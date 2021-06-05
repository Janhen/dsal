package com.janhen.coding.leetcode.algs.search.backtracking.practice.solution93;

import java.util.ArrayList;
import java.util.List;

class Solution2 {

    private final List<String> res = new ArrayList<>();

    // 1 ms, faster than 99.69%
    //21.1 MB, less than 73.22%
    public List<String> restoreIpAddresses(String s) {
        res.clear();
        backtracking(s, 0, 0, new StringBuilder());
        return res;
    }

    // 跳过一些循环
    private void backtracking(String s, int bit, int start, StringBuilder sb) {
        if (s.length() - start > (4 - bit) * 3 || s.length() - start < 4 - bit)
            return;
        if (bit == 3) {
            String cur = s.substring(start);
            if (isValid(cur)) {
                res.add(sb.append(cur).toString());
                sb.delete(sb.length() - cur.length(), sb.length());
                return;
            } else {
                return;
            }
        }
        String val = s.substring(start, Math.min(start + 1, s.length()));
        if (isValid(val)) {
            backtracking(s, bit + 1, start + 1, sb.append(s.charAt(start)).append("."));
            sb.delete(sb.length() - val.length() - 1, sb.length());

            val = s.substring(start, Math.min(start + 2, s.length()));
            if (isValid(val)) {
                backtracking(s, bit + 1, start + 2, sb.append(val).append("."));
                sb.delete(sb.length() - val.length() - 1, sb.length());

                val = s.substring(start, Math.min(start + 3, s.length()));
                if (isValid(val)) {
                    backtracking(s, bit + 1, start + 3, sb.append(val).append("."));
                    sb.delete(sb.length() - val.length() - 1, sb.length());
                }
            }
        }
    }

    // 验证字符串所表示数字的合法性  note: 0 特殊处理
    private boolean isValid(String str) {
        return str.length() <= 3 && str.length() > 0 &&
          ((str.length() <= 1 || str.charAt(0) != '0') &&    /* 对两位数和三位数首字符不应该为0 */
            Integer.parseInt(str) <= 255);
    }
}