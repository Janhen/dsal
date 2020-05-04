package main.java.janhen.leetcode.string.solution9;

// 9. Palindrome Number
//https://leetcode.com/problems/palindrome-number/description/

/*
Follow up:

Coud you solve it without converting the integer to a string?
 */

/*
 * 将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。
 * 543   345
 * 121   121
 */
class SolutionF {
    public boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0 || x % 10 == 0)
            return false;
        int origin = x;
        int right = 0;
        while (x != 0) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return origin == right;
    }
}