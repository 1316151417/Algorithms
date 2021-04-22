package com.swust.zj.leetcode.module4;

import com.swust.zj.leetcode.module3.No234_PalindromeLinkedList;

public class No206_ReverseLinkedList {

    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode l1 = head, l2 = head.next;
        l1.next = null;
        while (l2 != null) {
            ListNode l3 = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = l3;
        }
        return l1;
    }

}
