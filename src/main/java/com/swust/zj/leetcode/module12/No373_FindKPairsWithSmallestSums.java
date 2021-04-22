package com.swust.zj.leetcode.module12;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class No373_FindKPairsWithSmallestSums {

    static class Node implements Comparable<Node> {
        int val1;
        int val2;
        public Node(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
        @Override
        public int compareTo(Node other) {
            return (this.val1 + this.val2) - (other.val1 + other.val2);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<Node> minHeap = new PriorityQueue();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                minHeap.offer(new Node(num1, num2));
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        while (!minHeap.isEmpty() && k-- != 0) {
            Node node = minHeap.poll();
            List<Integer> result = new ArrayList<>();
            result.add(node.val1);
            result.add(node.val2);
            resultList.add(result);
        }
        return resultList;
    }

}
