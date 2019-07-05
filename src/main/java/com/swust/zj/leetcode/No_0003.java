package com.swust.zj.leetcode;

import java.util.HashSet;
import java.util.Set;

public class No_0003 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int max = 0, start = 0, end = 0;
        while (start < s.length() && end < s.length()) {
            if (!charSet.contains(s.charAt(end))) {
                charSet.add(s.charAt(end));
                max = Math.max(max, end - start + 1);
                end++;
            } else {
                charSet.remove(s.charAt(start++));
            }
        }
        return max;
    }
}
