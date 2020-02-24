package com.swust.zj.leetcode.byteDance.arrayAndSort;

public class No_0674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        int left = 0, right = 0;
        while(left < nums.length && right < nums.length) {
            if (left == right || nums[right] > nums[right - 1]) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                }
                right++;
            } else {
                left = right;
            }
        }
        return max;
    }

}
