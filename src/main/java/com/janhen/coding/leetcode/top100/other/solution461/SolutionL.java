package main.java.janhen.leetcode.top100.other.solution461;

class SolutionL {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}