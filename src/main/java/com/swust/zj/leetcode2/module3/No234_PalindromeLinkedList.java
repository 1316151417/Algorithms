package com.swust.zj.leetcode2.module3;

public class No234_PalindromeLinkedList {

    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
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

    public boolean equal(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2 == null;
        }
        if (l2 == null) {
            return l1 == null;
        }
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        // 分割链表
        ListNode leftTail = findMid(head);
        ListNode rightHead = leftTail.next;
        leftTail.next = null;
        // 反转右边的链表
        ListNode reverseRightHead = reverse(rightHead);
        // 对比左右链表是否一致
        return equal(head, reverseRightHead);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        System.out.println(new No234_PalindromeLinkedList().isPalindrome(n1));
    }

}
