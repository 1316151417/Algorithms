package com.swust.zj.leetcode.byteDance.dynamicAndGreedy;

public class No_0221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else if (matrix[i][j] == '1') {
                    int topDp = i - 1 < 0 ? 0 : dp[i - 1][j];
                    int leftDp = j - 1 < 0 ? 0 : dp[i][j - 1];
                    int topLeftDp = (i - 1 < 0 || j - 1 < 0) ? 0 : dp[i - 1][j - 1];
                    dp[i][j] = Math.min(Math.min(topDp, leftDp), topLeftDp) + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max * max;
    }

}
