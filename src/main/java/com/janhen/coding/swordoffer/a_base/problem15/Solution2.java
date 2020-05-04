package main.java.janhen.swordoffer.a_base.problem15;

public class Solution2 {
    public int NumberOf1(int n) {
        int cnt = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                cnt++;
            flag = flag << 1;
        }
        return cnt;
    }
}
