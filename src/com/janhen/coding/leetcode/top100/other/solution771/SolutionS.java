package com.janhen.leetcode.top100.other.solution771;

class SolutionS {
    public int numJewelsInStones(String J, String S) {
        boolean[] record = new boolean[256];      // 'z' + 1
        int cnt = 0;
        for (char c : J.toCharArray())
            record[c] = true;
        for (char c : S.toCharArray())
            if (record[c])
                cnt ++;
        return cnt;
    }
}