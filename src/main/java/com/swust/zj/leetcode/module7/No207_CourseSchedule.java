package com.swust.zj.leetcode.module7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] inArray = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inArray[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer canStudyCourse = queue.poll();
            List<Integer> nextCourseList = adjacency.get(canStudyCourse);
            for (Integer nextCourse : nextCourseList) {
                inArray[nextCourse]--;
                if (inArray[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] flagArray = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flagArray, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flagArray, int i) {
        if (flagArray[i] == -1) {
            return true;
        } else if (flagArray[i] == 1) {
            return false;
        }
        flagArray[i] = 1;
        for (Integer nextCourse : adjacency.get(i)) {
            if (!dfs(adjacency, flagArray, nextCourse)) {
                return false;
            }
        }
        flagArray[i] = -1;
        return true;
    }

}
