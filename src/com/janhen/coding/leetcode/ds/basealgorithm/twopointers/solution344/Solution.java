package com.janhen.coding.leetcode.ds.basealgorithm.twopointers.solution344;

// 344. Reverse String
// https://leetcode.com/problems/reverse-string/description/

/*翻转字符串*/

class Solution {
    private static void swap(char[] a, int i, int j) {
        a[i] = (char) (a[i] ^ a[j]);
        a[j] = (char) (a[i] ^ a[j]);
        a[i] = (char) (a[i] ^ a[j]);
    }

    // char as int to calculate
    public String reverseString(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j)
            swap(chars, i++, j--);
        return new String(chars);
    }

    // string as byte to calculate
    // 字符为 ASCII 时使用
    public String reverseString2(String s) {
        byte[] bytes = s.getBytes();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
            i++;
            j--;
        }
        return new String(bytes);
    }
}
