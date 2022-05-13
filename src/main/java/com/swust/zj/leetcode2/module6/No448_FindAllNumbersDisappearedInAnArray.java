package com.swust.zj.leetcode2.module6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No448_FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1) % nums.length;
            nums[index] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                resultList.add(i + 1);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(Arrays.toString(new No448_FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums).toArray()));
    }

}
