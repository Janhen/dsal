package main.java.janhen.leetcode.a_base.solution56;

import main.java.janhen.leetcode.structures.Interval;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() < 2) return intervals;

    List<Interval> res = new ArrayList<>();                            // Use defined structure
    intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

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
    res.add(new Interval(start, end));      // NOTE: must handle last element
    return res;
  }
}