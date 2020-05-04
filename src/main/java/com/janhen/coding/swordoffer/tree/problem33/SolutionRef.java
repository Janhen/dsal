package main.java.janhen.swordoffer.tree.problem33;

// 33. 二叉搜索树的后续遍历序列

import java.util.Arrays;

// 14ms
public class SolutionRef {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        int rstart = 0;
        int length = sequence.length;
        for (int i = 0; i < length - 1; i++) {
            if (sequence[i] < sequence[length - 1])
                rstart++;
        }
        if (rstart == 0) {
            VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,length-1));
        }else {
            for (int i = rstart; i < length - 1; i++) {
                if (sequence[i] <= sequence[length - 1]) {
                    return false;
                }
            }
            VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,rstart));
            VerifySquenceOfBST(Arrays.copyOfRange(sequence,rstart,length - 1));
        }
        return true;
    }
}
