package com.swust.zj.leetcode.module9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(candidates, target, -1, new ArrayList<>(), 0, resultList);
        return resultList;
    }

    private void backtrack(int[] candidates, int target, int lastIndex, List<Integer> current, Integer currentSum, List<List<Integer>> resultList) {
        if (currentSum == target) {
            resultList.add(new ArrayList<>(current));
        }
        if (currentSum >= target) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (i < lastIndex) {
                continue;
            }
            current.add(candidates[i]);
            backtrack(candidates, target, i, current, currentSum + candidates[i], resultList);
            current.remove(current.size() - 1);
        }
    }

}
