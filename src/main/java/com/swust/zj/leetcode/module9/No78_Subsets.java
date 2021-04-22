package com.swust.zj.leetcode.module9;

import java.util.ArrayList;
import java.util.List;

public class No78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
            backtrack(0, nums, new ArrayList<>(), resultList);
        return resultList;
    }

    private void backtrack(int index, int[] nums, List<Integer> result, List<List<Integer>> resultList) {
        if (index == nums.length) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        result.add(nums[index]);
        backtrack(index + 1, nums, result, resultList);
        result.remove(result.size() - 1);
        backtrack(index + 1, nums, result, resultList);
    }

}
