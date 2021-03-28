package com.janhen.coding.leetcode.ds.string.solution6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution2 {

  public String convert(String s, int numRows) {
    if (numRows == 1) return s;

    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < Math.min(numRows, s.length()); i++)
      rows.add(new StringBuilder());

    // 记录当前填充的行
    int curRow = 0;
    // 记录当前填充的方向
    boolean goingDown = false;

    for (char c : s.toCharArray()) {
      rows.get(curRow).append(c);
      if (curRow == 0 || curRow == numRows - 1) {
        goingDown = !goingDown;
      }
      curRow += goingDown ? 1 : -1;
    }

    return rows.stream().map(StringBuilder::toString).collect(Collectors.joining());
  }
}