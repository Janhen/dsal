package com.janhen.leetcode.greedy.solution435;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            int startDiff = o1.start - o2.start;
            if (startDiff != 0)
                return startDiff;
            return o1.end - o2.end;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {

        Arrays.sort(intervals, new IntervalComparator());



        return -1;

    }
}