package main.java.janhen.leetcode.recursionANDbacktracking.practice.solution401;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // todo error Q
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        backtracking(num, 0, new StringBuilder(), res);
        return res;
    }

    private void backtracking(int num, int count, StringBuilder sb, List<String> res) {
        if (10-sb.length() < num - count)
            return;
        if (count == num) {
            StringBuilder tmp = new StringBuilder(sb);
            while (sb.length() < 10) {
                sb.append('0');
            }
            int hour = Integer.valueOf(sb.substring(0, 4), 2);
            int minute = Integer.valueOf(sb.substring(4), 2);
            if (isValid(hour, minute))
                res.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
            sb = tmp;
            return;
        }
        sb.append('1');
        backtracking(num, count + 1, sb, res);
        sb.deleteCharAt(sb.length()-1);

        sb.append('0');
        backtracking(num, count, sb, res);
        sb.deleteCharAt(sb.length()-1);
    }

    private boolean isValid(int hour, int minute) {
        if (hour > 11 || minute > 59)
            return false;
        return true;
    }
}