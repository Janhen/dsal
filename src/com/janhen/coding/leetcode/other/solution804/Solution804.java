package com.janhen.coding.leetcode.other.solution804;

//804. Unique Morse Code Words
//        https://leetcode.com/problems/unique-morse-code-words/description/
//easy

import java.util.Set;
import java.util.TreeSet;

public class Solution804 {
    String[] answers = {".-","-...","-.-.","-..",".","..-.","--.","....", "",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        // check

        Set<String> set = new TreeSet<>();

        for (String word : words) {
            StringBuilder morseCode = new StringBuilder();
            for (char c : word.toCharArray())
                morseCode.append(answers[c - 'a']);

            set.add(morseCode.toString());
        }
        return set.size();
    }
}
