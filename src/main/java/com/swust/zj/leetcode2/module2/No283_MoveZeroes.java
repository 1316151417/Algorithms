package com.swust.zj.leetcode2.module2;

import java.util.Arrays;

public class No283_MoveZeroes {

    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
            right++;
        }
        int size = left;
        while (left < nums.length) {
            nums[left++] = 0;
        }
        return size;
    }

    public void moveZeroes(int[] nums) {
        removeElement(nums, 0);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new No283_MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
