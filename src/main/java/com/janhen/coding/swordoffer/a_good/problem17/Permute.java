package main.java.janhen.swordoffer.a_good.problem17;

import java.util.ArrayList;
import java.util.Arrays;

public class Permute {
    ArrayList<ArrayList<Character>> permute(char[] nums) {
        ArrayList<ArrayList<Character>> res = new ArrayList<>();
        backtracking(nums, 0, res);
        return res;
    }

    void backtracking(char[] nums, int start, ArrayList<ArrayList<Character>> res) {
        if (start == nums.length) {
            ArrayList<Character> list = new ArrayList<>();
            for (char num : nums)
                list.add(num);
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = start; i < nums.length; i ++) {
            swap(nums, start, i);
            backtracking(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    private static void swap(char[] a, int i, int j) {
        if (i == j)
            return;
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        (new Permute()).permute(new char[]{'0','1','2','3','4','5','6','7','8','9'});
    }
}
