package com.swust.zj.leetcode.module2;

public class No977_SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        // 找到绝对值最小的坐标
        int left = 0, right = nums.length - 1;
        int minAbsIndex = -1;
        while (left < right) {
            int leftAbs = Math.abs(nums[left]);
            int rightAbs = Math.abs(nums[right]);
            if (leftAbs <= rightAbs) {
                minAbsIndex = left;
                right--;
            } else {
                minAbsIndex = right;
                left++;
            }
        }
        int[] sortedSquares = new int[nums.length];
        int sortedSquaresIndex = 0;
        int minAbsIndexLeft = minAbsIndex, minAbsIndexRight = minAbsIndex + 1;
        while (minAbsIndexLeft >= 0 || minAbsIndexRight <= nums.length - 1) {
            // 都不越界
            if (minAbsIndexLeft >= 0 && minAbsIndexRight <= nums.length - 1) {
                int leftAbs = Math.abs(nums[minAbsIndexLeft]);
                int rightAbs = Math.abs(nums[minAbsIndexRight]);
                if (leftAbs <= rightAbs) {
                    // 左边绝对值小
                    sortedSquares[sortedSquaresIndex++] = nums[minAbsIndexLeft] * nums[minAbsIndexLeft];
                    minAbsIndexLeft--;
                } else {
                    // 右边绝对值小
                    sortedSquares[sortedSquaresIndex++] = nums[minAbsIndexRight] * nums[minAbsIndexRight];
                    minAbsIndexRight++;
                }
            }
            // 左边越界
            else if (minAbsIndexLeft < 0 && minAbsIndexRight <= nums.length - 1) {
                sortedSquares[sortedSquaresIndex++] = nums[minAbsIndexRight] * nums[minAbsIndexRight];
                minAbsIndexRight++;
            }
            // 右边越界
            else if (minAbsIndexLeft >= 0 && minAbsIndexRight > nums.length - 1) {
                sortedSquares[sortedSquaresIndex++] = nums[minAbsIndexLeft] * nums[minAbsIndexLeft];
                minAbsIndexLeft--;
            }
        }
        return sortedSquares;
    }

}
