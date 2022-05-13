package com.swust.zj.leetcode2.module6;

public class No41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        boolean containsOne = false;
        for (int i = 0; i < nums.length; i++) {
            containsOne = nums[i] == 1 ? true : containsOne;
            nums[i] = nums[i] >= 1 && nums[i] <= nums.length ? nums[i] : 1;
        }
        if (!containsOne) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(new No41_FirstMissingPositive().firstMissingPositive(nums));
    }

}
