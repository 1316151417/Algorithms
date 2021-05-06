package com.swust.zj.leetcode.module18;

public class NoJz56_ShuZuZhongShuZiChuXianDeCiShuLcof {

    public int[] singleNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        int first1 = 1;
        while ((result & first1) == 0) {
            first1 <<= 1;
        }
        int group1Result = 0;
        int group2Result = 0;
        for (int num : nums) {
            if ((num & first1) == 0) {
                group1Result ^= num;
            } else {
                group2Result ^= num;
            }
        }
        return new int[]{group1Result, group2Result};
    }

}
