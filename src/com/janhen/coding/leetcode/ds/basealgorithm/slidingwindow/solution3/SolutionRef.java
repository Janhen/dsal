package com.janhen.coding.leetcode.ds.basealgorithm.slidingwindow.solution3;

// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//
// 滑动窗口
// 时间复杂度: O(len(s))
// 空间复杂度: O(len(charset))
public class SolutionRef {

    // modify loop edge
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        int l = 0, r = -1;
        int max = 0;
        while (r + 1 < s.length()) {            // r+1<s.len
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
                freq[s.charAt(++r)]++;
            else    //freq[s[r+1]] == 1
                freq[s.charAt(l++)]--;
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
