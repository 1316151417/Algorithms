package com.swust.zj.leetcode2.module2;

import java.util.Arrays;

public class No977_SquaresOfASortedArray {

    public int abs(int num) {
        return num >= 0 ? num : -num;
    }

    public int square(int num) {
        return num * num;
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, index = right;
        int[] squares = new int[nums.length];
        while (left <= right) {
            if (abs(nums[left]) <= abs(nums[right])) {
                squares[index--] = square(nums[right]);
                right--;
            } else {
                squares[index--] = square(nums[left]);
                left++;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(new No977_SquaresOfASortedArray().sortedSquares(nums)));
    }
}
