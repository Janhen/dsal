package com.janhen.coding.swordoffer.a_base.problem21;

public class Solution {

    public void reOrderArray(int [] array) {
        int oddCnt = 0;
        for (int num : array){
            if (num % 2 == 1) {
                oddCnt ++;
            }
        }
        int oddIdx = 0, evenIdx = oddCnt;
        int[] aux = array.clone();
        for (int num : aux) {
            if (num % 2 == 1) {
                array[oddIdx ++] = num;
            } else {
                array[evenIdx ++] = num;
            }
        }
    }
}
