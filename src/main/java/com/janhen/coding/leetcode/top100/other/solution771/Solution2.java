package com.janhen.coding.leetcode.top100.other.solution771;


/*
 * 字符匹配
 * 在J 中查找S 的每个字符
 * O(n*m)
 */
public class Solution2 {
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        for (int i = 0; i < S.length(); i ++)
            if (J.indexOf(S.charAt(i)) > -1)
                cnt ++;
        return cnt;
    }
}
