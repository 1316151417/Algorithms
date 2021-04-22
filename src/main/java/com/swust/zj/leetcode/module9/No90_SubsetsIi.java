package com.swust.zj.leetcode.module9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90_SubsetsIi {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(false,0, nums, new ArrayList<>(), resultList);
        return resultList;
    }

    private void backtrack(boolean chooseLast, int index, int[] nums, List<Integer> result, List<List<Integer>> resultList) {
        if (index == nums.length) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        backtrack(false, index + 1, nums, result, resultList);
        if (!chooseLast && index >= 1 && nums[index - 1] == nums[index]) {
            return;
        }
        result.add(nums[index]);
        backtrack(true, index + 1, nums, result, resultList);
        result.remove(result.size() - 1);
    }

}
