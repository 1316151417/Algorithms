package com.swust.zj.leetcode.module11;

public class No33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int minIndex = binarySearchMinIndex(nums);
        if (target >= nums[minIndex] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, minIndex, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, minIndex, target);
        }
    }

    private int binarySearchMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
