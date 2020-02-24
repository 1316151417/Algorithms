package com.swust.zj.leetcode.byteDance.arrayAndSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_0056 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        List<Integer[]> resultList = new ArrayList<>();
        Integer lastStart = null;
        Integer lastEnd = null;
        for (int i = 0; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if (lastStart == null && lastEnd == null) {
                lastStart = currentStart;
                lastEnd = currentEnd;
            } else {
                if (currentStart <= lastEnd) {
                    lastStart = Math.min(lastStart, currentStart);
                    lastEnd = Math.max(lastEnd, currentEnd);
                } else {
                    Integer[] result = new Integer[2];
                    result[0] = lastStart;
                    result[1] = lastEnd;
                    resultList.add(result);
                    lastStart = currentStart;
                    lastEnd = currentEnd;
                }
            }
        }
        if (lastStart != null && lastEnd != null) {
            Integer[] result = new Integer[2];
            result[0] = lastStart;
            result[1] = lastEnd;
            resultList.add(result);
        }
        int[][] resultArray = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            Integer[] result = resultList.get(i);
            resultArray[i][0] = result[0];
            resultArray[i][1] = result[1];
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[][] merge = new No_0056().merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
