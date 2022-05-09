package com.swust.zj.leetcode2.module1;

import java.util.HashSet;
import java.util.Set;

public class No3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> tempMap = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            while (tempMap.contains(s.charAt(j))) {
                tempMap.remove(s.charAt(i++));
            }
            tempMap.add(s.charAt(j));
            max = tempMap.size() > max ? tempMap.size() : max;
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new No3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }

}
