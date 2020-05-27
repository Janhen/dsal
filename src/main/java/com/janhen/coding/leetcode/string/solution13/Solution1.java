package com.janhen.coding.leetcode.string.solution13;

// 13. Roman to Integer
//https://leetcode.com/problems/roman-to-integer/

class Solution1 {

    //  41 ms, faster than 88.25%
    //36 ms, faster than 97.78%
    public int romanToInt(String s) {
        int sum = 0;
        if (s.lastIndexOf("IX") != -1) sum -= 2;
        if (s.lastIndexOf("IV") != -1) sum -= 2;
        if (s.lastIndexOf("XL") != -1) sum -= 20;
        if (s.lastIndexOf("XC") != -1) sum -= 20;
        if (s.lastIndexOf("CD") != -1) sum -= 200;
        if (s.lastIndexOf("CM") != -1) sum -= 200;

        char c[]=s.toCharArray();
        int count=0;

        for(;count<=s.length()-1;count++){
            if(c[count]=='M') sum+=1000;
            if(c[count]=='D') sum+=500;
            if(c[count]=='C') sum+=100;
            if(c[count]=='L') sum+=50;
            if(c[count]=='X') sum+=10;
            if(c[count]=='V') sum+=5;
            if(c[count]=='I') sum+=1;
        }
        return sum;
    }
}