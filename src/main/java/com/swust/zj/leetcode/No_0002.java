package com.swust.zj.leetcode;

public class No_0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode cursor = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = val / 10;
            ListNode newNode = new ListNode(val % 10);
            if (root == null) {
                root = newNode;
                cursor = root;
            } else {
                cursor.next = newNode;
                cursor = cursor.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return root;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
