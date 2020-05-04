package main.java.janhen.leetcode.top100.other.solution406;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public class People {
        public int h;
        public int k;
        public int i;   //index of this people in people[][]

        public People(int h, int k, int i) {
            this.h = h;
            this.k = k;
            this.i = i;
        }
    }

    public class Compare implements Comparator<People> {
        public int compare(People p1, People p2) {
            if (p1.h != p2.h) return p2.h - p1.h;
            else return p1.k - p2.k;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) return new int[0][0];

        PriorityQueue<People> pq1 = new PriorityQueue(new Compare());
        for (int i = 0; i < people.length; i++) {
            pq1.add(new People(people[i][0], people[i][1], i));
        }

        List<Integer> list = new ArrayList<Integer>();

        while (!pq1.isEmpty()) {
            People p = pq1.poll();
            list.add(p.k, p.i); //p.k表示前面有几个人比它高，所以要插入在第k个位置

        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = people[list.get(i)][0];
            res[i][1] = people[list.get(i)][1];
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] a = new int[6][2];
        a[0] = new int[]{7, 0};
        a[1] = new int[]{4, 4};
        a[2] = new int[]{7, 1};
        a[3] = new int[]{5, 0};
        a[4] = new int[]{6, 1};
        a[5] = new int[]{5, 2};
        new Solution().reconstructQueue(a);
    }
}
