package com.swust.zj.leetcode.module17;

public class No889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post,
                0, pre.length - 1,
                0, post.length - 1);
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post,
                                         int preLeftIndex, int preRightIndex,
                                         int postLeftIndex, int postRightIndex) {
        if (preLeftIndex > preRightIndex) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeftIndex]);
        if (preLeftIndex < preRightIndex) {
            int splitValue = pre[preLeftIndex + 1];
            int postSplitIndex = findIndex(post, postLeftIndex, postRightIndex - 1, splitValue);
            int postLeftLength = postSplitIndex - postLeftIndex + 1;
            root.left = constructFromPrePost(pre, post,
                    preLeftIndex + 1, preLeftIndex + postLeftLength,
                    postLeftIndex, postLeftIndex + postLeftLength - 1);
            root.right = constructFromPrePost(pre, post,
                    preLeftIndex + postLeftLength + 1, preRightIndex,
                    postLeftIndex + postLeftLength, postRightIndex - 1);
        }
        return root;
    }

    private int findIndex(int[] nums, int left, int right, int target) {
        for (int i = left; i <= right && i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
