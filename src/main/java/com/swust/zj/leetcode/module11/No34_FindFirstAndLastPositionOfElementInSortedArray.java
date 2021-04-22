package com.swust.zj.leetcode.module11;

public class No34_FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchFirst(nums, target), searchLast(nums, target)};
    }

    private int searchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                if (mid - 1 >= 0 && target == nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int searchLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                if (mid + 1 < nums.length && target == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
