package com.swust.zj.leetcode.byteDance.dynamicAndGreedy;

public class No_0122 {

    public int maxProfit(int[] prices) {
        int sum = 0, buyIndex = 0, sellIndex = buyIndex + 1;
        while (buyIndex < prices.length && sellIndex < prices.length) {
            if (prices[buyIndex] >= prices[sellIndex]) {
                buyIndex++;
                sellIndex++;
            } else {
                if (sellIndex + 1 >= prices.length || prices[sellIndex + 1] < prices[sellIndex]) {
                    sum += prices[sellIndex] - prices[buyIndex];
                    buyIndex = sellIndex + 1;
                    sellIndex = buyIndex + 1;
                } else {
                    sellIndex++;
                }
            }
        }
        return sum;
    }

}
