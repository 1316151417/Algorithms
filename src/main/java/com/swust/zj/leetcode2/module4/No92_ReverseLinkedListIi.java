package com.swust.zj.leetcode2.module4;

public class No92_ReverseLinkedListIi {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode p = head, preNode = null, subHead = null, subTail = null, nextNode = null;
        int count = 0;
        while (p != null) {
            count++;
            if (count == left - 1) {
                preNode = p;
            } else if (count == left) {
                subHead = p;
            } else if (count == right) {
                subTail = p;
                nextNode = subTail.next;
            }
            p = p.next;
        }
        if (preNode != null) {
            preNode.next = null;
        }
        subTail.next = null;
        subTail = subHead;
        subHead = reverseList(subHead);
        if (preNode != null) {
            preNode.next = subHead;
        }
        subTail.next = nextNode;
        return preNode != null ? head : subHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        int left = 1;
        int right = 2;
        ListNode result = new No92_ReverseLinkedListIi().reverseBetween(n1, left, right);
        System.out.println(result);
    }
}
