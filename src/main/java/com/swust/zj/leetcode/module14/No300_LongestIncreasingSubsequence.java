package com.swust.zj.leetcode.module14;

public class No300_LongestIncreasingSubsequence {

    public int lengthOfLIS1(int[] nums) {
        int maxDp = 1;
        int[] dpArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dpArray[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpArray[i] = Math.max(dpArray[i], dpArray[j] + 1);
                }
            }
            maxDp = Math.max(maxDp, dpArray[i]);
        }
        return maxDp;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] minArray = new int[nums.length];
        minArray[0] = nums[0];
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            int insertPosition = searchInsertPosition(minArray, end, nums[i]);
            if (insertPosition == end + 1) {
                minArray[++end] = nums[i];
            } else {
                if (nums[i] < minArray[insertPosition]) {
                    minArray[insertPosition] = nums[i];
                }
            }
        }
        return end + 1;
    }

    private int searchInsertPosition(int[] minArray, int end, int num) {
        int left = 0;
        int right = end;
        int position = end + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num == minArray[mid]) {
                return mid;
            } else if (num < minArray[mid]) {
                right = mid - 1;
                position = mid;
            } else {
                left = mid + 1;
            }
        }
        return position;
    }

}
