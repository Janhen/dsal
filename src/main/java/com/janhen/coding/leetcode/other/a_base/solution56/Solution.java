package com.janhen.coding.leetcode.other.a_base.solution56;

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

    // record recent iteration pointer
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;

    for (Interval item : intervals) {
      // can merge
      if (item.start <= end) {
        end = Math.max(end, item.end);
      } else {
        res.add(new Interval(start, end));

        // reset
        start = item.start;
        end = item.end;
      }
    }
    // handle last element
    res.add(new Interval(start, end));
    return res;
  }
}