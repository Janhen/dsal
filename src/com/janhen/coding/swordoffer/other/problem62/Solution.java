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
        // 1. define original list, make (0,1,2,3,4,..,n-1)
        LinkedList<Integer> list = IntStream.range(0, n).boxed().collect(Collectors.toCollection(LinkedList::new));

        // find relational node and remove
        int idx = 0;
        // 2. continue to remove util only have one element
        while (list.size() > 1) {
            idx = (idx + m - 1) % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }
}
