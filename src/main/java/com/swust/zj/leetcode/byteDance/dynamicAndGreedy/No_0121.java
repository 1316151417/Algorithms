package com.swust.zj.leetcode.byteDance.dynamicAndGreedy;

public class No_0121 {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new No_0121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
