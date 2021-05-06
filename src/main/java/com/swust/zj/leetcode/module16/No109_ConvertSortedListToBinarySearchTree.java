package com.swust.zj.leetcode.module16;

public class No109_ConvertSortedListToBinarySearchTree {

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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        return middleBuild(0, length(head) - 1);
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private ListNode current;
    private TreeNode middleBuild(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = middleBuild(start, mid - 1);
        TreeNode parent = new TreeNode(current.val);
        current = current.next;
        TreeNode right = middleBuild(mid + 1, end);
        parent.left = left;
        parent.right = right;
        return parent;
    }

}
