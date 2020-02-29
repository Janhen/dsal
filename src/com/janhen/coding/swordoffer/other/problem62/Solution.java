package com.janhen.swordoffer.other.problem62;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 借助数据结构实现, 循环队列中的删除, 类似基于循环数组实现的队列
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0)
            return -1;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i ++)
            list.add(i);
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
