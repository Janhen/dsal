package com.janhen.coding.leetcode.top100.other.solution771;

public class SolutionS2 {
    // word frequency
    public int numJewelsInStones(String J, String S) {
        int[] freqs = new int[256];
        int cnt = 0;
        for (char c : S.toCharArray())
            freqs[c] ++;

        for (char c : J.toCharArray())
            if (freqs[c] > 0)
                cnt += freqs[c];
        return cnt;
    }
}
