package com.swust.zj.leetcode.module10;

import java.util.PriorityQueue;
import java.util.Queue;

public class No295_FindMedianFromDataStream {

    static class MedianFinder {

        /** initialize your data structure here. */
        private Queue<Integer> maxHeap;
        private Queue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() != minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }

}
