package com.swust.zj.leetcode.module16;

public class No114_FlattenBinaryTreeToLinkedList {

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

    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode newRight = current.left;
                TreeNode pre = newRight;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = current.right;
                current.left = null;
                current.right = newRight;
            }
            current = current.right;
        }
    }

    public void flatten2(TreeNode root) {
        build(root);
    }

    private TreeNode build(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = build(root.left);
        TreeNode right = build(root.right);
        if (left != null) {
            root.right = left;
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
            root.left = null;
        } else {
            root.right = right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode node5 = new TreeNode(5, null, node6);

        TreeNode node1 = new TreeNode(1, node2, node5);

        new No114_FlattenBinaryTreeToLinkedList().flatten(node1);
        System.out.println(node1);
    }

}
