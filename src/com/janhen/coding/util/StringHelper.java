package com.janhen.coding.util;

import java.util.Arrays;

public class StringHelper {
  public boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--))
        return false;
    }
    return true;
  }

  /**
   * 忽略特殊字符和大小写是否是回文字符串
   */
  public boolean isPalindrome(String s) {
    if (s.isEmpty())
      return true;

    int i = 0, j = s.length() - 1;
    char[] chs = s.toCharArray();
    while (i < j) {
      while (!Character.isLetterOrDigit(chs[i]) && i < j) {
        i++;
      }
      while (!Character.isLetterOrDigit(chs[j]) && i < j) {
        j--;
      }
      if (Character.toLowerCase(chs[i]) != Character.toLowerCase(chs[j]))  // ignore case compare
        return false;
      i++;
      j--;
    }
    return true;
  }

  public String sort(String s) {
    char[] chs = s.toCharArray();
    Arrays.sort(chs);
    return new String(chs);
  }
}
