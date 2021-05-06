package com.swust.zj.leetcode.module18;

public class NoJz56_ShuZuZhongShuZiChuXianDeCiShuIiLcof {

    public int singleNumber(int[] nums) {
        int result = 0;
        int current = 1;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & current) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                result += current;
            }
            current <<= 1;
        }
        return result;
    }

}
