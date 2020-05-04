package main.java.janhen.swordoffer.recursiont_dp.problem38;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, 0, res);
        res.sort(null);
        return res;
    }

    private void backtracking(char[] chars, int start, ArrayList<String> list) {
        if (start == chars.length - 1) {          // only one char, swap is self
            list.add(String.valueOf(chars));
            return;
        }
        for (int i = start; i < chars.length; i++) {
            if (!canSwap(chars, start, i)) continue;
            swap(chars, i, start);
            backtracking(chars, start + 1, list);
            swap(chars, i, start);
        }
    }

    private boolean canSwap(char[] chars, int start, int end) {
        for (int i = start; i < end; i ++)
            if (chars[end] == chars[i])
                return false;
        return true;
    }

    private void swap(char[] c, int i, int j) {
        if (i != j) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
        }
    }
}
