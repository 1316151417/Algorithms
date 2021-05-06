package com.swust.zj.leetcode.module18;

public class No190_ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return result;
    }

}
