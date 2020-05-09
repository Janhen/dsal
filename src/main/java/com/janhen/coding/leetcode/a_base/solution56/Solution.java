package com.janhen.coding.leetcode.a_base.solution56;

import com.janhen.coding.leetcode.structures.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() < 2)
      return intervals;

    List<Interval> res = new ArrayList<>();
    // Use defined structure attribute to sort
    intervals.sort(Comparator.comparingInt(o -> o.start));

    int start = intervals.get(0).start;                   // record recent
    int end = intervals.get(0).end;

    for (Interval item : intervals) {
      if (item.start <= end) { // can merge
        end = Math.max(end, item.end);
      } else {
        res.add(new Interval(start, end));
        start = item.start;
        end = item.end;             // reset
      }
    }
    // handle last element
    res.add(new Interval(start, end));
    return res;
  }
}