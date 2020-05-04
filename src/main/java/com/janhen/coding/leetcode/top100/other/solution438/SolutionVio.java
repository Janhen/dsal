package main.java.janhen.leetcode.top100.other.solution438;

// 438. Find All Anagrams in a String
// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Easy
// hash table

/*
找到字符串中的所有变位词的起始索引

字符全部为小写

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionVio {

    // Memory Limit Exceeded
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;

        Set<String> record = new HashSet<>();
        findAllPermutation(p.toCharArray(), 0, record);
        int m = s.length(), n = p.length();
        for (int i = 0; i < m - n + 1; i ++) {
            String key = s.substring(i, i + n);
            if (record.contains(key))
                res.add(i);
        }
        return res;
    }

    // 找出待匹配字符 p 的所有排列
    private void findAllPermutation(char[] chs, int start, Set<String> set) {
        if (start == chs.length) {
            set.add(new String(chs));
            return;
        }
        for (int i = start; i < chs.length; i ++) {
            swap(chs, i, start);
            findAllPermutation(chs, start + 1, set);
            swap(chs, i, start);
        }
    }

    private static void swap(char[] a, int i, int j) {
        if (i == j)
            return;
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}