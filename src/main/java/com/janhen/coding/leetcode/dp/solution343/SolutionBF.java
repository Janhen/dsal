package main.java.janhen.leetcode.dp.solution343;



import com.janhen.TestUtil;

class SolutionBF {
    // time : O(n^n)
    // space : O(n)
    public int integerBreak(int n) {
        TestUtil.printf("计算 %d 的整数分割", n);
        if (n == 1)
            return 1;
        int res = -1;
        for (int i = 1; i < n; i ++)                                         /* 当前从1,2,3,...,n-1 处分割, 代表对应的可能性总数, 也及分解成的子问题个数 */
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak(n - i)));  // 分割一次, 分割多次
        return res;
    }

    public static void main(String[] args) {
        int i = (new SolutionBF()).integerBreak(10);
        System.out.println(i);
    }

}