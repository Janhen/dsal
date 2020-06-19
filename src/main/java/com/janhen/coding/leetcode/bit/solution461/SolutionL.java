package com.janhen.coding.leetcode.bit.solution461;

class SolutionL {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}