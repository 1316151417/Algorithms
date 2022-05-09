package com.swust.zj.leetcode2.module1;

public class No121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int i = 0, j = 1, max = 0;
        while (i < prices.length && j < prices.length) {
            int profit = prices[j] - prices[i];
            max = profit > max ? profit : max;
            if (profit < 0) {
                i = j;
                j = i + 1;
            } else {
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new No121_BestTimeToBuyAndSellStock().maxProfit(prices));
    }

}
