package com.janhen.coding.swordoffer.a_base.problem21;

public class Solution {
    // 获取出奇数元素的个数，在新的数组中标记奇数和偶数开始的索引
    // time: O(N), space: O(N)
    public void reOrderArray(int[] arr) {
        // get odd count
        int oddCnt = 0;
        for (int num : arr) {
            if (num % 2 == 1) {
                oddCnt++;
            }
        }

        // tag odd, even index to assign element
        int oddIdx = 0, evenIdx = oddCnt;
        int[] aux = arr.clone();
        for (int num : aux) {
            if (num % 2 == 1) {
                arr[oddIdx++] = num;
            } else {
                arr[evenIdx++] = num;
            }
        }
    }
}
