package com.swust.zj.leetcode.module6;

public class NoJz3_ShuZuZhongZhongFuDeShuZiLcof {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] % nums.length;
            if (nums[index] >= nums.length) {
                return index;
            }
            nums[index] += nums.length;
        }
        return 0;
    }

}
