package com.janhen.coding.swordoffer.a_base.problem50;

import java.util.BitSet;

public class Solution2 {
    // 优化空间使用
    // 记录三种状态
    // 0 0 未出现过
    // 1 0 出现过一次
    // 1 1 出现过 >= 2 次
    public int FirstNotRepeatingChar(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                bs1.set(c);     // 0 0 -> 1 0
            } else if (bs1.get(c) && !bs2.get(c)) {
                bs2.set(c);     // 1 0 -> 1 1
            }
        }
        // like ...
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 1 0
            if (bs1.get(c) && !bs2.get(c)) {
                return i;
            }
        }
        return -1;
    }

}
