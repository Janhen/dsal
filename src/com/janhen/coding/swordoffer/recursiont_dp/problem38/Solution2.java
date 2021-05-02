package com.janhen.coding.swordoffer.recursiont_dp.problem38;

// 38 字符串的排列

/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 按照字典序排列的话，输出顺序为 123 132  213 231 312 321 ，
 * 也就是说，当前数的下一个数必须比它大，并且和它距离最短，这就是字典序排列。
 *
 * IN: [2,1,1,3]
 * OUT:
 * [[1,1,2,3],[1,1,3,2],[1,2,1,3],[1,2,3,1],[1,3,1,2],[1,3,2,1],
 * [2,1,1,3],[2,1,3,1],[2,3,1,1],
 * [3,1,1,2],[3,1,2,1],[3,2,1,1]]
 */
public class Solution2 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        backtracking(chs, new StringBuilder(), new boolean[chs.length], res);
        return res;
    }

    private void backtracking(char[] chs, StringBuilder sb, boolean[] visited, ArrayList<String> res) {
        if (sb.length() == chs.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chs.length; i ++) {
            if (visited[i]) continue;
            if (i > 0 && chs[i] == chs[i-1]  && !visited[i - 1]) continue;

            sb.append(chs[i]);
            visited[i] = true;
            backtracking(chs, sb, visited, res);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
