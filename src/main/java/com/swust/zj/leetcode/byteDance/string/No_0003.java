package com.swust.zj.leetcode.byteDance.string;

import java.util.HashMap;
import java.util.Map;

public class No_0003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int max = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (charIndexMap.containsKey(s.charAt(right))) {
                left = Math.max(left, charIndexMap.get(s.charAt(right)) + 1);
            }
            charIndexMap.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
