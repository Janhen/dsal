package com.janhen.coding.swordoffer.other.problem61;

import java.util.Arrays;

public class Solution {
    //
    public boolean IsContinuous(int[] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        // 1. get 0 count
        int count = 0;
        Arrays.sort(numbers);
        for (int val : numbers) {
            if (val == 0) {
                count++;
            } else {
                break;
            }
        }
        // 2. skip 0 element to traverse judge
        for (int i = count; i < numbers.length - 1; i++) {
            // have duplicate element, fast to fail ...
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            // try to make up blank element use 0
            int diff = numbers[i + 1] - numbers[i] - 1;
            count -= diff;
        }
        // 3. is or else have remaining 0
        return count >= 0;
    }
}
