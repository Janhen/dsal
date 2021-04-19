package com.janhen.coding.leetcode.ds.linkedlist.solution379;

import java.util.Arrays;

class PhoneDirectory {

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    private final boolean[] phone;
    private final int N;

    public PhoneDirectory(int maxNumbers) {
        this.N = maxNumbers;
        phone = new boolean[maxNumbers];
        Arrays.fill(phone, true); // true 表示可以使用
    }

    /**
     * 分配给用户一个未被使用的电话号码，获取失败请返回 -1.
     */
    public int get() {
        for (int i = 0; i < N; i++) {
            if (phone[i]) {
                phone[i] = false;
                return i;
            }
        }
        return -1;
    }

    /**
     * 检查指定的电话号码是否被使用.
     */
    public boolean check(int number) {
        return phone[number];
    }

    /**
     * 释放掉一个电话号码，使其能够重新被分配.
     */
    public void release(int number) {
        phone[number] = true;
    }
}