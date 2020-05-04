package main.java.janhen.swordoffer.a_base.problem15_2;

public class Solution {

    public static boolean isPower2(int n) {
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPower2(-2));
        System.out.println(isPower2(0));
        System.out.println(isPower2(1));
        System.out.println(isPower2(1));
        System.out.println(isPower2(2));
        System.out.println(isPower2(25));
        System.out.println(isPower2(8));
    }
}
