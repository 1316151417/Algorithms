package com.swust.zj.leetcode2.module3;

public class No61_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode p = head, tail = head;
        while (p != null) {
            length++;
            tail = p;
            p = p.next;
        }
        k = k % length;
        tail.next = head;
        int count = length - k;
        ListNode newHead = head, newTail = head;
        for (int i = 0; i < count; i++) {
            newTail = newHead;
            newHead = newHead.next;
        }
        newTail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        int k = 2;
        System.out.println(new No61_RotateList().rotateRight(n1, k));
    }
}
