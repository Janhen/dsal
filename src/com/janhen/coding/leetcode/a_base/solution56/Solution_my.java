package com.janhen.leetcode.a_base.solution56;

import com.janhen.leetcode.structures.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution_my {
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() < 2) return intervals;
    List<Interval> res = new ArrayList<>();
    intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));          // sort to greedy

    int start = intervals.get(0).start;
    int end = intervals.get(0).end;

    for (Interval item : intervals) {
      if (item.start <= end) {         // need merge
        end = Math.max(end, item.end);

      } else {    // need collect result
        res.add(new Interval(start, end));
        start = item.start;
        end = item.end;
      }
    }
    // handle end
    res.add(new Interval(start, end));
    return res;
  }
}
