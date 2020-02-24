package com.swust.zj.leetcode.byteDance.arrayAndSort;

public class No_0033 {

    public int search(int[] nums, int target) {
        int rotationIndex = binarySearchRotationIndex(nums);
        if (rotationIndex == -1) {
            return binarySearchTargetIndex(nums, target, 0, nums.length - 1);
        }
        if (target >= nums[0] && target <= nums[rotationIndex]) {
            return binarySearchTargetIndex(nums, target, 0, rotationIndex);
        } else if (target >= nums[rotationIndex + 1] && target <= nums[nums.length - 1]) {
            return binarySearchTargetIndex(nums, target, rotationIndex + 1, nums.length - 1);
        }
        return -1;
    }

    public int binarySearchRotationIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((mid + 1) < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchTargetIndex(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearchTargetIndex(nums, target, left, mid - 1);
        } else {
            return binarySearchTargetIndex(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(new No_0033().search(new int[]{8,9,2,3,4}, 9));
    }
}
