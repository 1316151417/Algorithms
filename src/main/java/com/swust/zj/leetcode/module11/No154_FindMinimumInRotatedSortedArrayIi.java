package com.swust.zj.leetcode.module11;

public class No154_FindMinimumInRotatedSortedArrayIi {

    public int findMin(int[] nums) {
        int rotationIndex = findRotationIndex(nums);
        return nums[rotationIndex + 1];
    }

    private int findRotationIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] == nums[nums.length - 1]) {
                right--;
            } else if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new No154_FindMinimumInRotatedSortedArrayIi().findMin(
                new int[]{10,1,10,10,10}
        );
    }

}
