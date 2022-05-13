package com.swust.zj.leetcode2.module5;

import java.util.ArrayList;
import java.util.List;

public class No57_InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList<>();
        int minStart = newInterval[0], maxEnd = newInterval[1];
        boolean addNewInterval = false;
        for (int i = 0; i < intervals.length; i++) {
            int intervalStart = intervals[i][0], intervalEnd = intervals[i][1];
            if (!addNewInterval && intervalStart > maxEnd) {
                ansList.add(new int[]{minStart, maxEnd});
                addNewInterval = true;
            }
            if (intervalEnd < minStart || intervalStart > maxEnd) {
                ansList.add(new int[]{intervalStart, intervalEnd});
                continue;
            }
            minStart = minStart < intervalStart ? minStart : intervalStart;
            maxEnd = maxEnd > intervalEnd ? maxEnd : intervalEnd;
        }
        if (!addNewInterval) {
            ansList.add(new int[]{minStart, maxEnd});
        }
        return ansList.toArray(new int[ansList.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] ans = new No57_InsertInterval().insert(intervals, newInterval);
        System.out.println(ans);
    }

}
