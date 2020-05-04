package main.java.janhen.swordoffer.a_base.problem10_3;

import java.util.Arrays;

public class Solution {
    //f(n) = f(n - 1) + f(n - 2) + f(n - 3) + f(2) + f(1);
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }
}
