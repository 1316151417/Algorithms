package com.swust.zj.leetcode.module5;

import java.util.ArrayList;
import java.util.List;

public class No57_InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            resultList.add(intervals[i++]);
        }
        int[] merge = newInterval;
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            int merge0Min = Math.min(intervals[i][0], merge[0]);
            int merge1Max = Math.max(intervals[i][1], merge[1]);
            merge = new int[]{merge0Min, merge1Max};
            i++;
        }
        resultList.add(merge);
        while (i < intervals.length) {
            resultList.add(intervals[i++]);
        }
        return resultList.toArray(new int[resultList.size()][2]);
    }

}
