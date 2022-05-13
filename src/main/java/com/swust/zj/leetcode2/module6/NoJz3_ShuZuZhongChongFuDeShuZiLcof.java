package com.swust.zj.leetcode2.module6;

public class  NoJz3_ShuZuZhongChongFuDeShuZiLcof {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[nums[i] % nums.length] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] / nums.length > 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new NoJz3_ShuZuZhongChongFuDeShuZiLcof().findRepeatNumber(nums));
    }

}
