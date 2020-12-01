package com.janhen.coding.util;

public class StringHelper {
  public boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--))
        return false;
    }
    return true;
  }
}
