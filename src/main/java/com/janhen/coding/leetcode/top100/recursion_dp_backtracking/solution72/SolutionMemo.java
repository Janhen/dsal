package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution72;

public class SolutionMemo {
    // 题目描述：修改一个字符串成为另一个字符串，使得修改次数最少。一次修改操作包括：插入一个字符、删除一个字符、替换一个字符。
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        memo = new Integer[word1.length() + 1][word2.length() + 1];
        return minDistance(word1.toCharArray(), 0, word1.length(), word2.toCharArray(), 0, word2.length());
    }

    private int minDistance(char[] chsA, int startA, int lenA, char[] chsB, int startB, int lenB) {
        if (memo[startA][startB] != null)
            return memo[startA][startB];
        if (startA >= lenA) {
            if (startB >= lenB) return memo[startA][startB] = 0;
            else return memo[startA][startB] = lenB - startB;
        }
        if (startB >= lenB) {
            if (startA >= lenA) return memo[startA][startB] = 0;
            else return memo[startA][startB] = lenA - startA;
        }
        if (chsA[startA] == chsB[startB]) {
            return memo[startA][startB] = minDistance(chsA, startA + 1, lenA, chsB, startB + 1, lenB);
        }
        int t1 = minDistance(chsA, startA+1, lenA, chsB, startB, lenB);
        int t2 = minDistance(chsA, startA, lenA, chsB, startB+1, lenB);
        int t3 = minDistance(chsA, startA+1, lenA, chsB, startB+1, lenB);
        return memo[startA][startB] = 1 + Math.min(t1, Math.min(t2, t3));
    }
}
