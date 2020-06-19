package com.janhen.coding.leetcode.search.backtracking.combinate.solution17;

import java.util.ArrayList;
import java.util.List;

class Solution2 {

    private final String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty())
            return res;
        backtracking(digits, new StringBuilder(), res);
        return res;
    }

    private void backtracking(String digits, StringBuilder sb, List<String> res) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return ;
        }
        int curDigit = digits.charAt(sb.length()) - '0';
        for (char c : letterMap[curDigit].toCharArray()) {
            sb.append(c);
            backtracking(digits, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}