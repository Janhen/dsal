package main.java.janhen.swordoffer.tree.problem33;

public class Solution_my {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return isValid(sequence, 0, sequence.length - 1);
    }

    private boolean isValid(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int firstRIdx = first;           // NOTE: must handle right sub tree is null tree
        for (int i = first; i <= last; i ++) {
            if (sequence[i] < sequence[last]) {
                firstRIdx ++;
            } else {
                break;
            }
        }
        for (int i = firstRIdx; i < last; i ++) {         // check
            if (sequence[i] < sequence[last]) {
                return false;
            }
        }
        return isValid(sequence, first, firstRIdx - 1) && isValid(sequence, firstRIdx, last - 1);
    }
}
