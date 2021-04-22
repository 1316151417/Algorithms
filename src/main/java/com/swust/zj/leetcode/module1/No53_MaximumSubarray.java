package com.swust.zj.leetcode.module1;

public class No53_MaximumSubarray {

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int left = 0, right = 0, sum = 0; right < nums.length; right++) {
            if (sum <= 0) {
                left = right;
                sum = nums[left];
            } else {
                sum += nums[right];
            }
            max = sum > max ? sum : max;
        }
        return max;
    }

    /**
     * 动态规划
     * 公式：
     *           data[0] (n=1)
     * dp[n] = {
     *           max(data[n-1] + data[n], data[n]) (n>1)
     * dp[n]表示以data[n]结尾的最大子序和，但不一定是最大子序和
     * 时间复杂度：O(n)
     * 空间复杂度（使用数据空间）：O(1)
     * 空间复杂度（不使用数据空间）：O(n)
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] > 0 ? (nums[i] + nums[i - 1]) : nums[i];
            max = nums[i] > max ? nums[i] : max;
        }
        return max;
    }

    /**
     * 贪心算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxSubArray3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0], max = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = sum > max ? sum : max;
        }
        return max;
    }

}
