/*
 * 字符串循环移位包含
 *
 * 编程之美 3.1
 *
 * s1 = AABCD, s2 = CDAA
 * Return : true
 * 给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
 *
 * s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
 *
 * 字符串循环移位
 *
 * 编程之美 2.17
 *
 * s = "abcd123" k = 3
 * Return "123abcd"
 * 将字符串向右循环移动 k 位。
 *
 * 将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，得到 123abcd。
 *
 * 字符串中单词的翻转
 *
 * 程序员代码面试指南
 *
 * s = "I am a student"
 * Return "student a am I"
 * 将每个单词翻转，然后将整个字符串翻转。
 */
package main.java.janhen.leetcode.string;