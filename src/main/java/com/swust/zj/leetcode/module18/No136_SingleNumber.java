package com.swust.zj.leetcode.module18;

public class No136_SingleNumber {

    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }

}
