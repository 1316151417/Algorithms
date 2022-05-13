package com.swust.zj.leetcode2.module5;

import java.util.ArrayList;
import java.util.List;

public class No986_IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ansList = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < firstList.length && secondIndex < secondList.length) {
            int firstStart = firstList[firstIndex][0],
                    firstEnd = firstList[firstIndex][1],
                    secondStart = secondList[secondIndex][0],
                    secondEnd = secondList[secondIndex][1];
            int maxStart = firstStart > secondStart ? firstStart : secondStart;
            int minEnd = firstEnd < secondEnd ? firstEnd : secondEnd;
            if (maxStart <= minEnd) {
                ansList.add(new int[]{maxStart, minEnd});
            }
            if (firstEnd < secondEnd) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }
        return ansList.toArray(new int[ansList.size()][2]);
    }

    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] ans = new No986_IntervalListIntersections().intervalIntersection(firstList, secondList);
        System.out.println(ans);
    }

}
