package com.swust.zj.leetcode.module14;

public class No1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            char char1 = text1.charAt(i);
            for (int j = 0; j < text2.length(); j++) {
                char char2 = text2.charAt(j);
                int lastDp1 = i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;
                int lastDp2 = i > 0 ? dp[i - 1][j] : 0;
                int lastDp3 = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = char1 == char2 ? lastDp1 + 1 : Math.max(lastDp2, lastDp3);
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }

    public static void main(String[] args) {
        new No1143_LongestCommonSubsequence().longestCommonSubsequence(
                "abc","abc"
        );
    }

}
