package com.swust.zj.leetcode2.module2;

import java.util.Arrays;

public class No167_TwoSumIiInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int result = numbers[left] + numbers[right];
            if (result == target) {
                return new int[]{left + 1, right + 1};
            } else if (result > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new No167_TwoSumIiInputArrayIsSorted().twoSum(numbers, target)));
    }

}
