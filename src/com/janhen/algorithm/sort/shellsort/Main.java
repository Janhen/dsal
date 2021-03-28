package com.janhen.algorithm.sort.shellsort;

import java.util.Arrays;

public class Main {

  public static void comparator(int[] arr) {
    Arrays.sort(arr);
  }

  public static int[] generateRandomArray(int size, int value) {

    int randomSize = (int) ((size + 1) * Math.random());
    int[] nums = new int[randomSize];

    for (int i = 0; i < nums.length; i++)
      nums[i] = (int) ((value + 1) * Math.random() - value * Math.random());

    return nums;
  }

  public static int[] copyArray(int[] nums) {
    if (nums == null)
      return null;

    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++)
      res[i] = nums[i];

    return res;
  }

  private static boolean isEqual(int[] arr1, int[] arr2) {

    if ((arr1 == null && arr2 != null) &&
      (arr1 != null && arr2 == null))
      return false;

    if (arr1 == null && arr2 == null)
      return true;

    if (arr1.length != arr2.length)
      return false;

    for (int i = 0; i < arr1.length; i++)
      if (arr1[i] != arr2[i])
        return false;
    return true;
  }

  private static void printArray(int[] nums) {
    for (int num : nums)
      System.out.print(num + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    int testTime = 500000;
    int size = 10;
    int value = 100;

    boolean succeed = true;
    for (int i = 0; i < testTime; i++) {
      int[] arr1 = generateRandomArray(size, value);
      int[] arr2 = copyArray(arr1);


      ShellSort.shellSort(arr1);
      comparator(arr2);
      if (!isEqual(arr1, arr2)) {
        succeed = false;
        printArray(arr1);
        printArray(arr2);
        break;
      }
    }

    System.out.println(succeed ? "Nice!" : "Failed!");

    int[] arr = generateRandomArray(size, value);
    printArray(arr);
    ShellSort.shellSort(arr);
    printArray(arr);
  }
}
