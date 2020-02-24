package com.swust.zj.leetcode.byteDance.arrayAndSort;

import java.util.HashSet;
import java.util.Set;

public class No_0128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxCount = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int count = 1, point = num;
                while (numSet.contains(point + 1)) {
                    count++;
                    point++;
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }

}
