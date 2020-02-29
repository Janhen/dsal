package com.janhen.swordoffer.a_good.problem53;

// 53 在排序数组中查找数字
// https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

public class Solution2 {
    public int GetNumberOfK(int [] arr , int k) {
        int first = binarySearchFirst(arr,k);
        int firstNot = binarySearchFirst(arr, k + 1);
        if (first == arr.length || arr[first] != k)
            return 0;
        return firstNot - first;
    }

    private int binarySearchFirst(int[] arr, int k) {
        int L = 0, R = arr.length;
        while (L < R) {
            int mid = (R - L) / 2 + L;
            if (arr[mid] >= k)
                R = mid ;
            else
                L = mid + 1;
        }
        return L;
    }
}
