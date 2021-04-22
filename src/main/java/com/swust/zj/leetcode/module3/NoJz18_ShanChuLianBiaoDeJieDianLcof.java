package com.swust.zj.leetcode.module3;

public class NoJz18_ShanChuLianBiaoDeJieDianLcof {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode p = head, lastP = null;
        while (p != null) {
            if (p.val == val) {
                if (lastP == null) {
                    ListNode newHead = p.next;
                    p.next = null;
                    return newHead;
                } else {
                    lastP.next = p.next;
                    p.next = null;
                    return head;
                }
            }
            lastP = p;
            p = p.next;
        }
        return head;
    }

}
