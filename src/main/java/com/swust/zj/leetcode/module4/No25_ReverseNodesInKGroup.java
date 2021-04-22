package com.swust.zj.leetcode.module4;

public class No25_ReverseNodesInKGroup {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = null, nextGroupHead = head, newHead = null;
        while (nextGroupHead != null) {
            ListNode groupHead = nextGroupHead;
            ListNode groupTail = groupHead;
            for (int i = 0; i < k - 1; i++) {
                groupTail = groupTail != null ? groupTail.next : null;
            }
            if (groupTail == null) {
                if (pre != null) {
                    pre.next = groupHead;
                }
                break;
            }
            if (newHead == null) {
                newHead = groupTail;
            }
            nextGroupHead = groupTail.next;
            ListNode p = groupHead, q = groupHead.next;
            groupHead.next = null;
            while (p != groupTail) {
                ListNode r = q.next;
                q.next = p;
                p = q;
                q = r;
            }
            if (pre != null) {
                pre.next = groupTail;
            }
            pre = groupHead;
        }
        return newHead != null ? newHead : head;
    }

}
