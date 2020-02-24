package com.swust.zj.leetcode.byteDance.arrayAndSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_0015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resultList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    resultList.add(result);
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (temp > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<List<Integer>> resultList = new No_0015().threeSum(new int[]{-2, 0, 0, 2, 2});
        for (List<Integer> result : resultList) {
            System.out.println(result.get(0) + "," + result.get(1) + "," + result.get(2));
        }
    }
}
