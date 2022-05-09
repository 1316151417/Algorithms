package com.swust.zj.leetcode2.module3;

public class NoJz18_ShanChuLianBiaoDeJieDianLcof {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        } else {
            ListNode p = head, pPre = null;
            while (p != null) {
                if (p.val == val) {
                    pPre.next = p.next;
                    p.next = null;
                    break;
                }
                pPre = p;
                p = p.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        int val = 5;
        System.out.println(new NoJz18_ShanChuLianBiaoDeJieDianLcof().deleteNode(n1, val));
        System.out.println(1);
    }

}
