package com.swust.zj.leetcode.byteDance.dynamicAndGreedy;

import java.util.Arrays;

public class No_0354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        //排序
        Arrays.sort(envelopes, (int[] a1, int[] a2) -> a1[0] - a2[0] != 0 ?
                a1[0] - a2[0] : a1[1] - a2[1]);
        //动态规划
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] &&
                        dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        //最大值
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
