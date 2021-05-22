package com.janhen.coding.swordoffer.tree.problem33;

public class Solution {
    // 拆分左右子树，判断有序性
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
        int firstRightTreeIdx = first;
        while (firstRightTreeIdx < last && sequence[firstRightTreeIdx] < rootVal) {
            firstRightTreeIdx++;
        }

        // compare all elements in right tree [firstRightIdx, last) must < rootVal
        for (int i = firstRightTreeIdx; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        // now to verify left tree(first, firstRightTreeIdx -1) and right tree(firstRightTreeIdx, last - 1)
        return verify(sequence, first, firstRightTreeIdx - 1) && verify(sequence, firstRightTreeIdx, last - 1);   // insure left and right tree to recursion
    }
}
