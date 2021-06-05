package com.janhen.coding.leetcode.algs.search.backtracking.combinate.solution17;

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

    // use StringBuilder reference to record middle result
    private void backtracking(String digits, StringBuilder sb, List<String> res) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(sb.length()) - '0';
        String letter = letterMap[digit];
        for (char ch : letter.toCharArray()) {
            sb.append(ch);
            backtracking(digits, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}