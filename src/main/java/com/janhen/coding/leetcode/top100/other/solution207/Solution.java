package main.java.janhen.leetcode.top100.other.solution207;

import java.util.ArrayList;
import java.util.List;

//  5 ms, faster than 97.11%
class Solution {
    // todo QQ
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graphic = buildGraphic(numCourses, prerequisites);
        boolean[] globalMarked = new boolean[numCourses];
        boolean[] localMarked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i ++)
            if (hasCycle(graphic, i, globalMarked, localMarked))
                return false;
        return true;
    }

    private boolean hasCycle(List<Integer>[] graphic, int curNode, boolean[] globalMarked, boolean[] localMarked) {
        if (localMarked[curNode])
            return true;
        if (globalMarked[curNode])
            return false;
        globalMarked[curNode] = true;
        localMarked[curNode] = true;

        for (int nextNode : graphic[curNode])
            if (hasCycle(graphic, nextNode, globalMarked, localMarked))
                return true;
        localMarked[curNode] = false;
        return false;
    }

    private List<Integer>[] buildGraphic(int numCourses, int[][] prerequisites) {
        List<Integer>[] graphic = new List[numCourses];
        for (int i = 0; i < numCourses; i ++)
            graphic[i] = new ArrayList<>();

        for (int[] pre : prerequisites)
            graphic[pre[0]].add(pre[1]);
        return graphic;
    }
}