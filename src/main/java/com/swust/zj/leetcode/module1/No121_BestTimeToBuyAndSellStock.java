package com.swust.zj.leetcode.module1;

public class No121_BestTimeToBuyAndSellStock {

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int max = 0;
        for (int left = 0, right = 0; right < prices.length; right++) {
            int result = prices[right] - prices[left];
            max = result > max ? result : max;
            if (prices[left] >= prices[right]) {
                left = right;
            }
        }
        return max;
    }

    /**
     * 动态规划（可以优化掉dp数组）
     * 公式：
     *           0 (n=0)
     * dp[n] = {
     *           max(0, dp[n-1] + diff(n)) (n>0)
     *         = max(0, dp[n-1] + data[n] - data[n-1])
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else {
                int diff = prices[i] - prices[i - 1];
                int result = dp[i - 1] + diff;
                dp[i] = result > 0 ? result : 0;
            }
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }

}
