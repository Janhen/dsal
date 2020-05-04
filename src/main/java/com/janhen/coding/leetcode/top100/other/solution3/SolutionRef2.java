package main.java.janhen.leetcode.top100.other.solution3;

// 15 ms, faster than 100.00%
public class SolutionRef2 {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;

        while (r + 1 < s.length()) {
            while (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)   // find first can satisfy condition sliding window， 扩展直到[r+1] ∃相同元素
                freq[s.charAt(++ r)] ++;
            res = Math.max(res, r - l + 1);
            if (r + 1 < s.length()) {
                freq[s.charAt(++r)]++;                      // freq[r] = 2, 收缩到 [r] 为截至满足条件的窗口
                while (l <= r && freq[s.charAt(r)] == 2)
                    freq[s.charAt(l++)]--;
            }
        }
        return res;
    }
}
