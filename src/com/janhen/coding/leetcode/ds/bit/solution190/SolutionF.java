package com.janhen.coding.leetcode.ds.bit.solution190;

import java.util.HashMap;
import java.util.Map;

public class SolutionF {
    // cache
    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

    // 将 int 拆成 4 个 byte，然后缓存 byte 对应的比特位翻转，最后再拼接起来。
    public int reverseBits(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) // convert int into 4 bytes
            bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]); // reverse per byte
            if (i < 3)
                result <<= 8;
        }
        return result;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b); // first look up from cache
        if (value != null)
            return value;
        value = 0;
        // reverse by bit
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7)
                value <<= 1;
        }
        cache.put(b, value);
        return value;
    }
}