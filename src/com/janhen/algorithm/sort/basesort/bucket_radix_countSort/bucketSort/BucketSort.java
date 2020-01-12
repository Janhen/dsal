package com.janhen.algorithm.sort.basesort.bucket_radix_countSort.bucketSort;

/**
 * 桶排序
 *
 * @author Janhen
 */
public class BucketSort {
    // size:　numerical range
    // time:O(n)
    // space:O(n)
    public static void bucketSort(int [] nums) {
        if (nums == null || nums.length < 2)
            return ;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // ST2: insure data range and data offset
        // ST3: queue assign
        int[] bucket = new int[max - min + 1];
        for (int num : nums)
            bucket[num - min] ++;

        int k = 0;
        for (int i = 0; i < bucket.length; i ++) {
            while (bucket[i] -- > 0)
                nums[k ++] = i + min;
        }
    }
}
