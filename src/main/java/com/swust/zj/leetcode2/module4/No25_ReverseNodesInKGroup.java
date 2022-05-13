package com.swust.zj.leetcode2.module4;

public class No25_ReverseNodesInKGroup {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, q = p.next;
        head.next = null;
        while (q != null) {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode p = head, preTail = null, subHead = null, subTail = null, nextHead = null, newHead = null;
        int count = 0;
        while (p != null) {
            ListNode pNext = p.next;
            count = (count + 1) % k;
            if (count == 1) {
                subHead = p;
                preTail = subTail;
            } else if (count == 0) {
                subTail = p;
                nextHead = subTail.next;

                if (preTail != null) {
                    preTail.next = null;
                }
                subTail.next = null;

                subTail = subHead;
                subHead = reverseList(subHead);

                if (preTail != null) {
                    preTail.next = subHead;
                }
                subTail.next = nextHead;

                if (newHead == null) {
                    newHead = subHead;
                }
            }
            p = pNext;
        }
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
        ListNode result = new No25_ReverseNodesInKGroup().reverseKGroup(n1, k);
        System.out.println(result);
    }

}
