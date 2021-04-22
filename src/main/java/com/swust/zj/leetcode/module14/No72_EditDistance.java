package com.swust.zj.leetcode.module14;

public class No72_EditDistance {

    public int minDistance1(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() + word2.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] =  min(
                        dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1),
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1
                );
            }
        }
        return dp[word1.length()][word2.length()];
    }

    private int min(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }

}
