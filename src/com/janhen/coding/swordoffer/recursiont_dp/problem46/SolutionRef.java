package com.janhen.swordoffer.recursiont_dp.problem46;

// 46 把数字翻译成字符串
//https://leetcode.com/problems/decode-ways/description/

/*
给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，
例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */

public class SolutionRef {
    public int numDecodings(String s) {
        int n = s.length();
        // dp[0] as the result, so dp[n] can init      ==>> judge [i, i + 1]
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        // from tail begin traverse
        for (int i = n - 2; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0')
                continue;
            else {
                // i, i + 1 not i + 1, i + 2
                if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else
                    dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

}
