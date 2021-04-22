package com.swust.zj.leetcode.module13;

public class No21_MergeTwoSortedLists {

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode current = null;
        while (l1 != null || l2 != null) {
            ListNode minNode = null;
            if (l1 == null || (l2 != null && l2.val <= l1.val)) {
                minNode = l2;
                l2 = l2.next;
            } else {
                minNode = l1;
                l1 = l1.next;
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
