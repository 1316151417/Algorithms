package com.swust.zj.leetcode;

public class No_0005 {

    public static void main(String[] args) {
        System.out.println(new No_0005().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int maxLengthI = 0;
        int maxLengthJ = 0;
        boolean[][] data = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            data[i][i] = true;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                data[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || data[i + 1][j - 1]);
                if (data[i][j] && (j - i > maxLengthJ - maxLengthI)) {
                    maxLengthI = i;
                    maxLengthJ = j;
                }
            }
        }
        return s.substring(maxLengthI, maxLengthJ + 1);
    }
}
