package com.swust.zj.leetcode.module3;

public class No234_PalindromeLinkedList {

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

    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode reversedL2 = reverse(mid.next);
        boolean result = isEqualByL2(head, reversedL2);
        ListNode l2 = reverse(reversedL2);
        merge(head, l2);
        return result;
    }

    private ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode l1 = head, l2 = head.next;
        l1.next = null;
        while (l2 != null) {
            ListNode l3 = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = l3;
        }
        return l1;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        while (l1.next != null) {
            l1 = l1.next;
        }
        l1.next = l2;
        return l1;
    }

    private boolean isEqualByL2(ListNode l1, ListNode l2) {
        while (l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

}
