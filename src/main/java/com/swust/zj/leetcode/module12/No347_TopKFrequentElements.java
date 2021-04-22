package com.swust.zj.leetcode.module12;

import java.util.*;

public class No347_TopKFrequentElements {

    static class Node implements Comparable<Node> {
        int val;
        int count;
        public Node(int val) {
            this.val = val;
        }
        @Override
        public int compareTo(Node other) {
            return this.count - other.count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int num : nums) {
            Node node = nodeMap.get(num);
            if (node == null) {
                node = new Node(num);
                nodeMap.put(num, node);
            }
            node.count++;
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (Node node : nodeMap.values()) {
            minHeap.add(node);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> resultList = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            resultList.add(minHeap.poll().val);
        }
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

}
