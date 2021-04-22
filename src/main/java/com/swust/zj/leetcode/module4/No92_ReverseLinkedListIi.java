package com.swust.zj.leetcode.module4;

public class No92_ReverseLinkedListIi {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode myHead = new ListNode(-1);
        myHead.next = head;

        doReverseBetween(myHead, left + 1, right + 1);

        ListNode realHead = myHead.next;
        myHead.next = null;
        return realHead;
    }

    private ListNode doReverseBetween(ListNode head, int left, int right) {
        ListNode pre = head;
        for (int i = 0; i < left - 2; i++) {
            pre = pre.next;
        }
        ListNode current = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode currentNext = current.next;
            current.next = currentNext.next;
            currentNext.next = pre.next;
            pre.next = currentNext;
        }
        return head;
    }

}
