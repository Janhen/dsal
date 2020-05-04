package main.java.janhen.swordoffer.recursiont_dp.problem46;

public class Solution_my {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return s.charAt(0) == '0' ? 0 : 1;

        int n = s.length();
        int[] dp = new int[n];
        dp[0] = isValid(s, 0, 0) ? 1 : 0;
        dp[1] = (isValid(s, 1, 1) ? dp[0] : 0) + (isValid(s, 0, 1) ? 1 : 0);    // handle Ternary operator
        for (int i = 2; i < s.length(); i ++) {
            dp[i] += isValid(s, i, i) ? dp[i - 1] : 0;
            dp[i] += isValid(s, i-1, i) ? dp[i - 2] : 0;
        }
        return dp[n - 1];
    }

    private boolean isValid(String str, int i, int j) {
        if (i == j)
            return str.charAt(i) != '0';
        int num = Integer.parseInt(str.substring(i, j + 1));
        return num >= 10 && num <= 26;
    }
}
