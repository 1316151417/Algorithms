package com.swust.zj.leetcode.module14;

public class No10_RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char char2 = p.charAt(j - 1);
                char realChar2 = char2 == '*' ?
                        p.charAt(j - 2) : p.charAt(j - 1);
                boolean equal = i != 0 && (s.charAt(i - 1) == realChar2 || realChar2 == '.');
                if (char2 == '*') {
                    dp[i][j] = equal ?
                            (dp[i - 1][j] || dp[i][j - 2]) : dp[i][j - 2];
                } else {
                    dp[i][j] = equal ? dp[i - 1][j - 1] : false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
