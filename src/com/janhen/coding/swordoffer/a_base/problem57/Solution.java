package com.janhen.coding.swordoffer.a_base.problem57;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if (array.length < 2) return new ArrayList<>();
        int i = 0, j = array.length - 1;
        int curSum = 0;
        while (i < j) {
            curSum = array[i] + array[j];
            if (curSum == sum)
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            else if (curSum < sum) {
                i ++;
            } else {
                j --;
            }
        }
        return new ArrayList<>();
    }
}
