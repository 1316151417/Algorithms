package com.swust.zj.leetcode.module17;

public class No1008_ConstructBinarySearchTreeFromPreorderTraversal {

    public class TreeNode {
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

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(preorder[left]);
        }
        int index = findFirstLessThanTargetIndex(preorder, left, right, preorder[left]);
        return new TreeNode(
                preorder[left],
                build(preorder, left + 1, index),
                build(preorder, index + 1, right)
        );
    }

    private int findFirstLessThanTargetIndex(int[] preorder, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (preorder[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

}
