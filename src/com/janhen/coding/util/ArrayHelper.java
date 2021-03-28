package com.janhen.coding.util;

import java.util.Arrays;

public class ArrayHelper {
  public int findKthLargest(int[] nums, int k) {
    k = nums.length - k;
    int l = 0, h = nums.length - 1;
    while (l < h) {
      int j = partition(nums, l, h);
      if (j == k) {
        break;
      } else if (j < k) {
        l = j + 1;
      } else {
        h = j - 1;
      }
    }
    return nums[k];
  }

  private int partition(int[] a, int l, int h) {
    int i = l, j = h + 1;
    while (true) {
      while (a[++i] < a[l] && i < h) ;
      while (a[--j] > a[l] && j > l) ;
      if (i >= j) {
        break;
      }
      swap(a, i, j);
    }
    swap(a, l, j);
    return j;
  }

  private void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  // 两个有序数组中找第 kth 大的元素
  public double findKth(int[] nums1, int idx1, int[] nums2, int idx2, int k) {
    // pre-process input value, special value handle
    assert nums1.length - idx1 + nums2.length - idx2 >= k;
    if (idx1 >= nums1.length)
      return nums2[idx2 + k - 1];
    if (idx2 >= nums2.length)
      return nums1[idx1 + k - 1];
    if (k == 1)
      return Math.min(nums1[idx1], nums2[idx2]);

    int pivot1 = idx1 + k / 2 - 1 < nums1.length ? nums1[idx1 + k / 2 - 1] : Integer.MAX_VALUE;
    int pivot2 = idx2 + k / 2 - 1 < nums2.length ? nums2[idx2 + k / 2 - 1] : Integer.MAX_VALUE;
    if (pivot1 <= pivot2) {
      // skip A left narrow k/2, find in A right, B all
      return findKth(nums1, idx1 + k / 2, nums2, idx2, k - k / 2);
    }
    else {
      // skip B left narrow k/2, find in A all, B right
      return findKth(nums1, idx1, nums2, idx2 + k / 2, k - k / 2);
    }
  }

  public int findKth(int[] nums1, int[] nums2, int k) {
    /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 这里的 "/" 表示整除
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */

    int length1 = nums1.length, length2 = nums2.length;
    int index1 = 0, index2 = 0;
    int kthElement = 0;

    while (true) {
      // 边界情况
      if (index1 == length1) {
        return nums2[index2 + k - 1];
      }
      if (index2 == length2) {
        return nums1[index1 + k - 1];
      }
      if (k == 1) {
        return Math.min(nums1[index1], nums2[index2]);
      }

      // 正常情况
      int half = k / 2;
      int newIndex1 = Math.min(index1 + half, length1) - 1;
      int newIndex2 = Math.min(index2 + half, length2) - 1;
      int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
      if (pivot1 <= pivot2) {
        k -= (newIndex1 - index1 + 1);
        index1 = newIndex1 + 1;
      } else {
        k -= (newIndex2 - index2 + 1);
        index2 = newIndex2 + 1;
      }
    }
  }

  private int binarySearchFirst(int[] nums, int lo, int hi, int key) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == key) {
        if (mid == 0 || nums[mid - 1] != nums[mid]) return mid;
        else hi = mid - 1;
      } else if (nums[mid] < key) {
        lo = mid + 1;
      } else
        hi = mid - 1;
    }
    return -1;
  }

  public int binarySearchLast(int[] nums, int lo, int hi, int key) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == key) {
        if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) return mid;
        else lo = mid + 1;
      } else if (nums[mid] < key) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }

  public int binarySearchFloor(int[] nums, int lo, int hi, int key) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] <= key) {
        if (mid == nums.length - 1 || nums[mid + 1] > key) return mid;
        else lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }

  public int binarySearchCeil(int[] nums, int lo, int hi, int key) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] >= key) {
        if (mid == 0 || nums[mid - 1] < key) return mid;
        else hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return -1;
  }

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

  /**
   * 返回两个数组中最长的公共的元素
   *
   * @param arr1
   * @param arr2
   * @return
   */
  public int[] merge(int[] arr1, int[] arr2) {
    return null;
  }
}
