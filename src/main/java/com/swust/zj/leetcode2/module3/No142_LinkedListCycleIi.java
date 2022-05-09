package com.swust.zj.leetcode2.module3;

public class No142_LinkedListCycleIi {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean first = true;
        ListNode p = head, q = head;
        while (p != null && q != null && (first || p != q)) {
            p = p.next;
            q = q.next != null ? q.next.next : null;
            first = false;
        }
        if (p == null || q == null || p != q) {
            return null;
        }
        ListNode r = head;
        while (p != r) {
            p = p.next;
            r = r.next;
        }
        return p;
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
        System.out.println(new No142_LinkedListCycleIi().detectCycle(n1));
        System.out.println(new No142_LinkedListCycleIi().detectCycle(n1).val);
    }

}
