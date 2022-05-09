package com.swust.zj.leetcode2.module3;

public class No141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p = head, q = head.next;
        while (p != null && q != null && p != q) {
            p = p.next;
            q = q.next != null ? q.next.next : null;
        }
        return p != null && q != null && p == q;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(new No141_LinkedListCycle().hasCycle(n1));
    }

}
