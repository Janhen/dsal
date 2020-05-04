package main.java.janhen.swordoffer.recursiont_dp.problem19;

// 19 正则表达式匹配

/*
请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.'
表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。

在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
 */

/*
 * 解法
 * 判断模式中第二个字符是否是 *：
 *   若是，看如果模式串第一个字符与字符串第一个字符是否匹配：
 *     若不匹配，在模式串上向右移动两个字符j+2，相当于 a* 被忽略
 *     若匹配，字符串后移i+1。此时模式串可以移动两个字符j+2，也可以不移动j。
 *   若不是，看当前字符与模式串的当前字符是否匹配，即 str[i] == pattern[j] || pattern[j] == '.'：
 *     若匹配，则字符串与模式串都向右移动一位，i+1，j+1。
 *     若不匹配，返回 fasle。
 *
 * 15ms
 */
public class SolutionMemo {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        memo = new int[str.length+1][pattern.length+1];    // 0->not init,-1->false, 1->true

        return match(str, 0, str.length, pattern, 0, pattern.length);
    }

    int[][] memo;

    private boolean match(char[] str, int i, int len1,
                          char[] pattern, int j, int len2) {
        if (memo[i][j] != 0) {
            return memo[i][j] == 1 ? true : false;
        }

        if (i == len1 && j == len2) {
            memo[len1][len2] = 1;
            return true;
        }

        // "",".*"
        if (i != len1 && j == len2) {
            memo[i][len2] = -1;
            return false;
        }

        if (j + 1 < len2 && pattern[j + 1] == '*') {
            if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
                boolean hasMatch = match(str, i, len1, pattern, j + 2, len2)
                        || match(str, i + 1, len1, pattern, j, len2)
                        || match(str, i + 1, len1, pattern,j + 2, len2);
                memo[i][j] = hasMatch ? 1 : -1;
                return hasMatch;
            }

            // "",".*"
            boolean hasMatch = match(str, i, len1, pattern, j + 2, len2);
            memo[i][j] = hasMatch ? 1 : -1;
            return hasMatch;

        }

        if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
            boolean hasMatch = match(str, i + 1, len1, pattern, j + 1, len2);
            memo[i][j] = hasMatch ? 1 : -1;
            return hasMatch;
        }
        memo[i][j] = -1;
        return false;
    }
}
