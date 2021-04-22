package com.swust.zj.leetcode.module1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NoJz57_HeWeiSDeLianXuZhengShuXuLieLcof {

    /**
     * 时间复杂度：O(target/2)
     * 空间复杂度：O(1)
     */
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> resultLists = new ArrayList<>();
        Deque<Integer> result = new LinkedList<>();
        int sum = 0;
        for (int left = 1, right = 1; left < (target / 2 + 1); right++) {
            sum += right;
            result.addLast(right);
            while (sum > target) {
                sum -= left;
                result.removeFirst();
                left++;
            }
            if (sum == target) {
                resultLists.add(new ArrayList<>(result));
            }
        }
        int[][] resultArray = new int[resultLists.size()][];
        for (int i = 0; i < resultLists.size(); i++) {
            List<Integer> resultList = resultLists.get(i);
            resultArray[i] = new int[resultList.size()];
            for (int j = 0; j < resultList.size(); j++) {
                resultArray[i][j] = resultList.get(j);
            }
        }
        return resultArray;
    }

}
