package com.swust.zj.leetcode2.module1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class No239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int i = 0, j = 0, ansIndex = 0;
        while (i < nums.length && j < nums.length) {
            while (!q.isEmpty() && nums[j] > q.peekLast()) {
                q.pollLast();
            }
            q.addLast(nums[j]);
            if (j - i + 1 == k) {
                ans[ansIndex++] = q.peekFirst();
                if (nums[i] == q.peekFirst()) {
                    q.pollFirst();
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new No239_SlidingWindowMaximum().maxSlidingWindow(nums, k)));
    }

}
