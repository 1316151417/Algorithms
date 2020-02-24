package com.swust.zj.leetcode.byteDance.string;

import java.util.ArrayList;
import java.util.List;

public class No_0151 {
    public String reverseWords(String s) {
        List<String> wordList = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                wordBuilder.append(s.charAt(i));
            }
            if ((s.charAt(i) == ' ' || i == s.length() - 1) && wordBuilder.length() != 0) {
                wordList.add(wordBuilder.toString());
                wordBuilder = new StringBuilder();
            }
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = wordList.size() - 1; i >= 0; i--) {
            if (i != wordList.size() - 1) {
                resultBuilder.append(" ");
            }
            resultBuilder.append(wordList.get(i));
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No_0151().reverseWords("the sky is blue"));
    }
}
