package com.janhen.algorithm.find.binarysearch;

import java.util.Arrays;

/**
 * 变种的二分查找
 *
 * @author Janhen
 */
public class BinarySearch2 {

  // first | last

  /**
   * 查找元素第一次出现的位置
   *
   * @param nums 含有重复元素的数组
   * @param lo   左边界
   * @param hi   右边界
   * @param key  查找的值
   * @return
   */
  public int binarySearchFirst(int[] nums, int lo, int hi, int key) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == key) {
        if (mid == 0 || nums[mid - 1] != nums[mid])
          return mid;
        else
          hi = mid - 1;
      } else if (nums[mid] < key) {
        lo = mid + 1;
      } else
        hi = mid - 1;
    }
    return -1;
  }

  /**
   * 查找元素最后一次出现的位置
   *
   * @param nums 含有重复元素的数组
   * @param lo   左边界
   * @param hi   右边界
   * @param key  查找的值
   * @return
   */
  public int binarySearchLast(int[] nums, int lo, int hi, int key) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == key) {
        if (mid == nums.length - 1 || nums[mid] != nums[mid + 1])
          return mid;
        else
          lo = mid + 1;
      } else if (nums[mid] < key) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }

  // floor | ceil

  /**
   * 查找<=元素的位置
   *
   * @param nums 含有重复元素的数组
   * @param lo   左边界
   * @param hi   右边界
   * @param key  查找的值
   * @return
   */
  public int binarySearchFloor(int[] nums, int lo, int hi, int key) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] <= key) {
        if (mid == nums.length - 1 || nums[mid + 1] > key)
          return mid;
        else
          lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }

  /**
   * 查找>=元素的位置
   *
   * @param nums 含有重复元素的数组
   * @param lo   左边界
   * @param hi   右边界
   * @param key  查找的值
   * @return
   */
  public int binarySearchCeil(int[] nums, int lo, int hi, int key) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] >= key) {
        if (mid == 0 || nums[mid - 1] < key)
          return mid;
        else
          hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return -1;
  }

  // offset

  /**
   * 按照指定偏移查找元素的位置
   *
   * @param nums   含有重复元素的数组
   * @param lo     左边界
   * @param hi     右边界
   * @param key    查找的值
   * @param offset 偏移值
   * @return
   */
  public int binarySearchOffset(int[] nums, int lo, int hi, int key, int offset) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int realMid = (mid + offset) % nums.length;
      if (nums[realMid] == key) {
        return mid;
      } else if (nums[mid] < key) {
        lo = mid + 1;
      } else
        hi = mid - 1;
    }
    return -1;
  }

  /**
   * 按照指定偏移查找元素的位置<br>
   * 借助JDK工具实现
   *
   * @param nums   含有重复元素的数组
   * @param key    查找的值
   * @param offset 偏移值
   * @return
   */
  public int binarySearchOffset2(int[] nums, int key, int offset) {
    int firstIndex = offset;
    if (nums[nums.length - 1] >= key) {
      int index = Arrays.binarySearch(nums, firstIndex, nums.length, key);
      return index >= 0 ? index : -1;
    } else {
      int index = Arrays.binarySearch(nums, 0, firstIndex, key);
      return index >= 0 ? index : -1;
    }
  }
}
