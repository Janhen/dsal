package com.janhen.coding.leetcode.hashtable.solution447;

// 447. Number of Boomerangs
// https://leetcode.com/problems/number-of-boomerangs/description/
// easy
// hash table

// Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
// such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
//
//Find the number of boomerangs.
// You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
//
//Example:
//Input:
//[[0,0],[1,0],[2,0]]
//
//Output:
//2
//
//Explanation:
//The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

import java.util.HashMap;

class SolutionREF {
    // todo
    //  57 ms, faster than 99.92%
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        HashMap<Integer, Integer> distMap = new HashMap<Integer, Integer>();
        for (int[] i : points) {
            for (int[] j : points) {
                if (i == j) continue;
                int dist = (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
                int prevDist = distMap.containsKey(dist) ? distMap.get(dist) : 0;
                result += 2 * prevDist;
                distMap.put(dist, prevDist + 1);
            }
            distMap.clear();
        }
        return result;
    }
}
