package com.swust.zj.leetcode.module5;

import java.util.ArrayList;
import java.util.List;

public class No986_IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> resultList = new ArrayList<>();
        int firstIndex = 0, secondIndex = 0;
        while (firstIndex < firstList.length && secondIndex < secondList.length) {
            int index0Max = firstList[firstIndex][0] > secondList[secondIndex][0] ?
                    firstList[firstIndex][0] : secondList[secondIndex][0];
            int index1Min = firstList[firstIndex][1] < secondList[secondIndex][1] ?
                    firstList[firstIndex][1] : secondList[secondIndex][1];
            if (index0Max <= index1Min) {
                resultList.add(new int[]{index0Max, index1Min});
            }
            if (firstList[firstIndex][1] > secondList[secondIndex][1]) {
                secondIndex++;
            } else {
                firstIndex++;
            }
        }
        return resultList.toArray(new int[resultList.size()][2]);
    }

}
