package com.janhen.coding.swordoffer.other.problem61;

import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5)
            return false;
        int count = 0;
        Arrays.sort(numbers);
        for (int val: numbers) {
            if (val == 0) count ++;
            else break;
        }
        for (int i = count; i < numbers.length -1; i ++) {
            if (numbers[i+1] == numbers[i])
                return false;
            int diff = numbers[i+1] - numbers[i] - 1;
            count -= diff;
        }
        return count >= 0 ? true : false;
    }
}
