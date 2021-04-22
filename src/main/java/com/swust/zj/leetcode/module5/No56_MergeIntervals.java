package com.swust.zj.leetcode.module5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        List<int[]> resultList = new ArrayList<>();
        int[] merge = null;
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (merge == null) {
                merge = current;
            } else {
                if (merge[1] >= current[0]) {
                    merge[1] = merge[1] > current[1] ? merge[1] : current[1];
                } else {
                    resultList.add(merge);
                    merge = current;
                }
            }
            if (i == intervals.length - 1) {
                resultList.add(merge);
            }
        }
        return resultList.toArray(new int[resultList.size()][2]);
    }

}
