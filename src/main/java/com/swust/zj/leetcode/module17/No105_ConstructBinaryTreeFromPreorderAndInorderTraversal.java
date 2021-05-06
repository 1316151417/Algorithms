package com.swust.zj.leetcode.module17;

public class No105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder,
                0, preorder.length - 1,
                0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder,
                      int preLeft, int preRight,
                      int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootIndexInInorder = findIndex(inorder, inLeft, inRight, preorder[preLeft]);
        int rootLeftLength = rootIndexInInorder - inLeft;
        return new TreeNode(
                preorder[preLeft],
                build(preorder, inorder, preLeft + 1, preLeft + rootLeftLength, inLeft, rootIndexInInorder - 1),
                build(preorder, inorder, preLeft + rootLeftLength + 1, preRight, rootIndexInInorder + 1, inRight)
        );
    }

    private int findIndex(int[] inorder, int inLeft, int inRight, int target) {
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}