package com.janhen.coding.swordoffer.other.problem61;

import java.util.Arrays;

public class Solution_my {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int count = 0;
        for (int num : numbers) {                     // collect 大小鬼数量
            if (num == 0) {
                count ++;
            } else {             // sorted property
                break;
            }
        }

        for (int i = count + 1; i < numbers.length; i ++) {       // NOTE: From count begin to iterator
            if (numbers[i] == numbers[i-1]) {
                return false;
            }
            int curDiff = numbers[i] - numbers[i - 1];
            count -= curDiff - 1;
        }
        return count >= 0;
    }
}
