package com.janhen.coding.swordoffer.recursiont_dp.problem46;

public class SolutionDp {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;         // next logic only handle have two elements condition
        }

        int n = s.length();
        int[] dp = new int[n];
        dp[0] = isValid(s, 0, 0) ? 1 : 0;
        dp[1] = (isValid(s, 1, 1) ? dp[0] : 0) + (isValid(s, 0, 1) ? 1 : 0);
        for (int i = 2; i < n; i++) {
            dp[i] += isValid(s, i, i) ? dp[i - 1] : 0;                // [i] is or not can be independent character
            dp[i] += isValid(s, i - 1, i) ? dp[i - 2] : 0;          // [i-1,i] is or not can be independent character
        }
        return dp[n - 1];
    }

    // only 1~9 AND 10~26 is valid
    private boolean isValid(String s, int i, int j) {
        if (i == j)
            return s.charAt(i) != '0';             // one bit 1~9 valid

        int num = Integer.parseInt(s.substring(i, j + 1));
        return num >= 10 && num <= 26;     // two bit 10~26 valid
    }

    public static void main(String[] args) {
        System.out.println(new SolutionDp().numDecodings("10"));
    }
}
