package com.swust.zj.leetcode.module9;

import java.util.ArrayList;
import java.util.List;

public class No46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(nums, used, new ArrayList<>(), resultList);
        return resultList;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> result, List<List<Integer>> resultList) {
        if (result.size() == nums.length) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            result.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, result, resultList);
            used[i] = false;
            result.remove(result.size() - 1);
        }
    }

}
