package com.swust.zj.leetcode.module1;


import java.util.Deque;
import java.util.LinkedList;

public class No239_SlidingWindowMaximum {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxArray = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        int left = 0, right = 0;
        for (; right < k; right++) {
            while (!deque.isEmpty() && nums[right] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[right]);
        }
        maxArray[index++] = deque.peekFirst();
        for (; right < nums.length; left++, right++) {
            if (!deque.isEmpty() && nums[left] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[right] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[right]);
            maxArray[index++] = deque.peekFirst();
        }
        return maxArray;
    }

}
