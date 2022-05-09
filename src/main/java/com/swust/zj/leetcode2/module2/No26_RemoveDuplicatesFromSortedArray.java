package com.swust.zj.leetcode2.module2;

import java.util.Arrays;

public class No26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while (left < nums.length && right < nums.length) {
            while (right < nums.length && nums[right] <= nums[left]) {
                right++;
            }
            if (left < nums.length && right < nums.length) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new No26_RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
