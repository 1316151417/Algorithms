package com.swust.zj.leetcode.module1;

import java.util.HashSet;
import java.util.Set;

public class No3_LongestSubstringWithoutRepeatingCharacters {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(字符集数量)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        Set<Character> cSet = new HashSet<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            while (cSet.contains(rightChar)) {
                cSet.remove(s.charAt(left));
                left++;
            }
            cSet.add(rightChar);
            max = cSet.size() > max ? cSet.size() : max;
        }
        return max;
    }

}
