package com.swust.zj.leetcode.module2;

public class No283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        int firstZeroIndex = 0, firstNotZeroIndex = 0;
        while (firstNotZeroIndex < nums.length) {
            while (firstNotZeroIndex < nums.length && nums[firstNotZeroIndex] == 0) {
                firstNotZeroIndex++;
            }
            if (firstNotZeroIndex >= nums.length) {
                break;
            }
            nums[firstZeroIndex++] = nums[firstNotZeroIndex++];
        }
        while (firstZeroIndex < nums.length) {
            nums[firstZeroIndex++] = 0;
        }
    }

}
