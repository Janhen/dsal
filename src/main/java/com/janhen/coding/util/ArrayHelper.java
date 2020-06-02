package com.janhen.coding.util;

public class ArrayHelper {

  private boolean outOfBound(int r, int c, int m, int n) {
    return r >= m || r < 0 || c >= n || c < 0;
  }
}
