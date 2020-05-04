package main.java.janhen.swordoffer.other.problem62;

// 15ms
public class Solution3 {

    // 约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。
    // 因为是圆圈，所以最后需要对 n 取余。
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)
            return -1;
        if (n == 1)
            return 0;
        return (LastRemaining_Solution(n-1, m) + m) % n;
    }
}
