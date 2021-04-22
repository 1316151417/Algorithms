package com.swust.zj.leetcode.module2;

public class No167_TwoSumIiInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int result = numbers[left] + numbers[right];
            if (result == target) {
                return new int[]{left + 1, right + 1};
            } else if (result < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

}
