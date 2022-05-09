package com.swust.zj.leetcode2.module1;

import java.util.*;

public class NoJz57_HeWeiSDeLianXuZhengShuXuLieLcof {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> resultLists = new ArrayList<>();
        Deque<Integer> tempDeque = new LinkedList<>();
        int left = 1, right = 1, sum = 0;
        sum += left;
        tempDeque.add(left);

        while (right < target) {
            if (sum == target) {
                resultLists.add(new ArrayList<>(tempDeque));
            }
            if (sum > target) {
                sum -= left;
                tempDeque.removeFirst();
                left++;
            } else {
                right++;
                sum += right;
                tempDeque.add(right);
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

    public static void main(String[] args) {
        int target = 9;
        int[][] resultArray = new NoJz57_HeWeiSDeLianXuZhengShuXuLieLcof().findContinuousSequence(target);
        for (int[] result : resultArray) {
            System.out.println(Arrays.toString(result));
        }
    }

}
