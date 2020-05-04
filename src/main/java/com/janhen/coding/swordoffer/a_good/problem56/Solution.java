package main.java.janhen.swordoffer.a_good.problem56;

public class Solution {
    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        if (nums == null || nums.length < 2)
            return ;

        int xorRes = 0;
        for (int num : nums)
            xorRes ^= num;

        int index = findIndexInIntFromLowToHist(xorRes);
        for (int num : nums) {
            if (isBit1InIndex(num, index)){
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    private int findIndexInIntFromLowToHist(int val) {
        int idx = 0;
        while ((val & 1) != 1) {
            idx ++;
            val = val >> 1;    // shift right
        }
        return idx;
    }

    private boolean isBit1InIndex(int val, int index) {
        val = val >> index;
        return (val & 1) == 1;
    }
}
