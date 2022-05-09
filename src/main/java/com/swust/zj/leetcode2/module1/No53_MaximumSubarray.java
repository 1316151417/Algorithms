package com.swust.zj.leetcode2.module1;

public class No53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
        while (i < nums.length && j < nums.length) {
            sum += nums[j];
            max = sum > max ? sum : max;
            if (sum < 0) {
                sum = 0;
                i = j = j + 1;
            } else {
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new No53_MaximumSubarray().maxSubArray(nums));
    }

}
