package com.swust.zj.leetcode2.module2;

import java.util.Arrays;

public class No27_RemoveElement {

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

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(new No27_RemoveElement().removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

}
