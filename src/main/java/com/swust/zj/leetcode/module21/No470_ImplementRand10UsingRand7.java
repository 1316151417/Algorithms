package com.swust.zj.leetcode.module21;

public class No470_ImplementRand10UsingRand7 {

    private int rand7() {
        return 0;
    }

    public int rand10() {
        while (true) {
            int result = rand7() + (rand7() - 1) * 7;
            if (result <= 40) {
                return (result - 1) % 10 + 1;
            }
        }
    }

}
