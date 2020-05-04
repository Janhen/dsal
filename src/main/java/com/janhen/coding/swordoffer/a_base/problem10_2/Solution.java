package main.java.janhen.swordoffer.a_base.problem10_2;

public class Solution {

    public int JumpFloor(int target) {
        if (target <= 2)
            return target;
        int pre1 = 2, pre2 = 1;
        int res = 0;
        for (int i = 2; i < target; i++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}
