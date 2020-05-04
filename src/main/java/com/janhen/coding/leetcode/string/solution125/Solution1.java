package main.java.janhen.leetcode.string.solution125;

// 125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/description/

public class Solution1 {

    // enhance find
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int i = 0, j = s.length() - 1;
        char[] chs = s.toCharArray();
        while (i < j) {
            while (!Character.isLetterOrDigit(chs[i]) && i < j) i ++;
            while (!Character.isLetterOrDigit(chs[j]) && i < j) j --;
            if (Character.toLowerCase(chs[i]) != Character.toLowerCase(chs[j]))  // ignore case compare
                return false;
            i ++;
            j --;
        }
        return true;
    }
}