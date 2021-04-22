package com.swust.zj.leetcode.module13;

import java.util.PriorityQueue;
import java.util.Queue;

public class No23_MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists1(lists);
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> minHeap = new PriorityQueue<>(
                lists.length,
                (o1, o2) -> o1.val - o2.val
        );
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            minHeap.add(list);
        }
        ListNode head = null;
        ListNode current = null;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            if (head == null) {
                head = min;
                current = min;
            } else {
                current.next = min;
                current = min;
            }
            if (min.next != null) {
                minHeap.add(min.next);
            }
        }
        return head;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode leftListNode = merge(lists, left, mid);
        ListNode rightListNode = merge(lists, mid + 1, right);
        return merge(leftListNode, rightListNode);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode newHead = null;
        ListNode current = null;
        while (node1 != null || node2 != null) {
            ListNode minNode = null;
            if (node1 == null || (node2 != null && node2.val <= node1.val)) {
                minNode = node2;
                node2 = node2.next;
            } else {
                minNode = node1;
                node1 = node1.next;
            }
            if (newHead == null) {
                newHead = minNode;
                current = minNode;
            } else {
                current.next = minNode;
                current = minNode;
            }
        }
        return newHead;
    }

}
