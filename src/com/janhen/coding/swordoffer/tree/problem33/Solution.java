package com.janhen.coding.swordoffer.tree.problem33;

public class Solution {
    // LRD
    // 3 2 1 5 8 7 4
    // LLLLL ^ RRR ^
    //    cutIndex Root
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    // dfs   [first, cutIndex-1] left,  [cutIndex, last-1] right;
    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        // find right tree index
        int rootVal = sequence[last];
        int firstRightIdx = first;
        while (firstRightIdx < last && sequence[firstRightIdx] < rootVal) {
            firstRightIdx++;
        }

        // compare all elements in right tree
        for (int i = firstRightIdx; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, first, firstRightIdx - 1) && verify(sequence, firstRightIdx, last - 1);   // insure left and right tree to recursion
    }
}
