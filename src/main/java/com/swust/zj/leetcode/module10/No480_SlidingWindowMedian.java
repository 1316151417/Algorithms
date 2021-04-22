package com.swust.zj.leetcode.module10;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class No480_SlidingWindowMedian {

    private Queue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
    private Queue<Integer> minHeap = new PriorityQueue<>();

    private void add(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        fix();
    }

    private void remove(int num) {
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        fix();
    }

    private void fix() {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
        }
        return maxHeap.peek();
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            if (maxHeap.size() + minHeap.size() > k) {
                remove(nums[i - k]);
            }
            if (maxHeap.size() + minHeap.size() == k) {
                resultList.add(findMedian());
            }
        }
        double[] resultArray = new double[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

}
