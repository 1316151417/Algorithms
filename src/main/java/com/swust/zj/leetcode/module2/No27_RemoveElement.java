package com.swust.zj.leetcode.module2;

public class No27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int firstValIndex = 0, firstNotValIndex = 0, length = 0;
        while (firstNotValIndex < nums.length) {
            while (firstNotValIndex < nums.length && nums[firstNotValIndex] == val) {
                firstNotValIndex++;
            }
            if (firstNotValIndex >= nums.length) {
                break;
            }
            nums[firstValIndex++] = nums[firstNotValIndex++];
            length++;
        }
        while (firstValIndex < nums.length) {
            nums[firstValIndex++] = val;
        }
        return length;
    }

}
