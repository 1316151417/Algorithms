package com.swust.zj.leetcode.module19;

public class No8_StringToIntegerAtoi {

    public int myAtoi(String s) {
        int flag = 1;
        int result = 0;
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && s.charAt(i) == '-') {
            flag = -1;
        }
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            i++;
        }
        while (i < s.length() && isDigit(s.charAt(i))) {
            int current = s.charAt(i) - '0';
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && current > 7)) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + current;
            i++;
        }
        return flag * result;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

}
