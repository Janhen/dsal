package com.janhen.coding.swordoffer.other.problem62;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    // 借助数据结构实现, 循环队列中的删除, 类似基于循环数组实现的队列
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        // define original list
        LinkedList<Integer> list = IntStream.range(0, n).boxed().collect(Collectors.toCollection(LinkedList::new));
        // find relational node and remove
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
