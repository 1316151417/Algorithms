package com.swust.zj.leetcode.byteDance.string;

public class No_0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left > right) {
            return "";
        }
        if (left == right) {
            return strs[left];
        }
        int mid = (right + left) / 2;
        String leftLcp = longestCommonPrefix(strs, left, mid);
        String rightLcp = longestCommonPrefix(strs, mid + 1, right);
        return getLcp(leftLcp, rightLcp);
    }

    private String getLcp(String leftLcp, String rightLcp) {
        int minLength = Math.min(leftLcp.length(), rightLcp.length());
        for (int i = 0; i < minLength; i++) {
            if (leftLcp.charAt(i) != rightLcp.charAt(i)) {
                return leftLcp.substring(0, i);
            }
        }
        return leftLcp.substring(0, minLength);
    }
}
