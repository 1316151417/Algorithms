package com.swust.zj.leetcode.module17;

public class No106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, inorder,
                0, postorder.length - 1,
                0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int[] inorder,
                           int postLeft, int postRight,
                           int inLeft, int inRight) {
        if (postLeft > postRight) {
            return null;
        }
        int rootIndexInInorder = findIndex(inorder, inLeft, inRight, postorder[postRight]);
        int rootLeftLength = rootIndexInInorder - inLeft;
        return new TreeNode(
                postorder[postRight],
                build(postorder, inorder, postLeft, postLeft + rootLeftLength - 1, inLeft, rootIndexInInorder - 1),
                build(postorder, inorder, postLeft + rootLeftLength, postRight - 1, rootIndexInInorder + 1, inRight)
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
