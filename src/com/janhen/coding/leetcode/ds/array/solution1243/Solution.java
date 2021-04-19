package com.janhen.coding.leetcode.ds.array.solution1243;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> transformArray(int[] arr) {
        int length = arr.length;
        if (length <= 2) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }

        // flag to skip loop
        boolean isChange = true;
        int[] lastArr;
        while (isChange) {
            isChange = false;
            lastArr = Arrays.copyOf(arr, length);
            // 根据情况找处在波谷、波峰的值，并相应的处理
            for (int i = 1; i < length - 1; i++) {
                if (lastArr[i] > lastArr[i - 1] && lastArr[i] > lastArr[i + 1]) {
                    arr[i]--;
                    isChange = true;
                }
                if (lastArr[i] < lastArr[i - 1] && lastArr[i] < lastArr[i + 1]) {
                    arr[i]++;
                    isChange = true;
                }
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
