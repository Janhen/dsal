package com.janhen.coding.swordoffer.tree.problem33;

public class Solution {

    // LRD
    // 3 2 1 5 8 7 4
    // LLLLL ^ RRR ^
    //    cutIndex Root
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    // dfs   [first, cutIndex-1] left,  [cutIndex, last-1] right;
    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1)
            return true;
        int rootVal = sequence[last];
        int firstRIdx = first;
        while (firstRIdx < last && sequence[firstRIdx] < rootVal)
            firstRIdx++;
        for (int i = firstRIdx; i < last; i++)     // compare all elements in right tree
            if (sequence[i] < rootVal)
                return false;
        return verify(sequence, first, firstRIdx - 1) && verify(sequence, firstRIdx, last - 1);   // insure left and right tree to recursion
    }
}
