package com.janhen.coding.leetcode.algs.search.backtracking.combinate.solution17;

//17. Letter Combinations of a Phone Number
//        https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import com.janhen.TestUtil;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {

    private final String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",};


    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        res.clear();
        if (digits.isEmpty())
            return res;

        findCombinations(digits, 0, "");
        return res;
    }

    private void findCombinations(String digits, int index, String str) {
        System.out.println(index + " : " + str);

        if (index == digits.length()) {
            res.add(str);
            System.out.println("get " + str + " , return");
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i ++) {
            System.out.println("digits[" + index + "] = " + c + " , use " + letters.charAt(i) );
            findCombinations(digits, index + 1, str + letters.charAt(i));
        }

        System.out.println("digits[" + index + "] = " + c + "complete, return");
        return;
    }


    public static void main(String[] args) {
        TestUtil.printList(
                (new SolutionTest()).letterCombinations("234")
        );
    }

}
