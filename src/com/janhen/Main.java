package com.janhen;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 10, 12, 14, 16, 16};
        findUniqueValue(arr);

        System.out.println(Arrays.toString(randomArr()));
    }

    public static List<Integer> findUniqueValue(int[] arr) {
        // val -> freq
        int[] freqs = new int[111];
        for (int i = 0; i < arr.length; i++) {
            freqs[i]++;
        }
        List<Integer> result = new ArrayList<>(15);
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }

    public static int[] randomArr() {
        return randomArr(new HashSet<>(), 15, 10, 110)
          .stream().mapToInt(i -> i).toArray();
    }

    public static Set<Integer> randomArr(Set<Integer> set, int length, int min, int max) {
        //   生成随机数
        int num = (int) Math.floor(Math.random() * (max - min + 1)) + min;
        if (!set.contains(num)) {
            // 数组不存在该值
            set.add(num);
        }
        // 递归进行
        return set.size() == length ? set : randomArr(set, length, min, max);
    }
}