package com.swust.zj.leetcode2.module5;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (array1, array2) -> {
            int result = array1[0] - array2[0];
            return result != 0 ? result : (array1[1] - array2[1]);
        });
        List<int[]> resultList = new ArrayList<>();
        Integer minStart = intervals[0][0], maxEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0], currentEnd = intervals[i][1];
            if (maxEnd >= currentStart) {
                maxEnd = currentEnd > maxEnd ? currentEnd : maxEnd;
            } else {
                resultList.add(new int[]{minStart, maxEnd});
                minStart = currentStart;
                maxEnd = currentEnd;
            }
        }
        resultList.add(new int[]{minStart, maxEnd});
        return resultList.toArray(new int[resultList.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] result = new No56_MergeIntervals().merge(intervals);
        System.out.println(result);
    }

}
