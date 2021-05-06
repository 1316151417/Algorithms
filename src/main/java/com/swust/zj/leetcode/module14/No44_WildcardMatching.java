package com.swust.zj.leetcode.module14;

public class No44_WildcardMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            char char2 = p.charAt(j - 1);
            if (char2 == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            char char1 = s.charAt(i - 1);
            for (int j = 1; j <= p.length(); j++) {
                char char2 = p.charAt(j - 1);
                if (char2 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (char2 == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = char1 == char2 && dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
