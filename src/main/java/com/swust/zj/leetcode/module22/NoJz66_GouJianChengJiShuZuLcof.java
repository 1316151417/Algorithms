package com.swust.zj.leetcode.module22;

public class NoJz66_GouJianChengJiShuZuLcof {

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] result = new int[a.length];
        int[] dp1 = new int[a.length];
        int[] dp2 = new int[a.length];
        dp1[0] = 1;
        for (int i = 1; i < a.length; i++) {
            dp1[i] = dp1[i - 1] * a[i - 1];
        }
        dp2[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            dp2[i] = dp2[i + 1] * a[i + 1];
        }
        for (int i = 0; i < a.length; i++) {
            result[i] = dp1[i] * dp2[i];
        }
        return result;
    }

}
