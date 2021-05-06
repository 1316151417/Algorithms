package com.swust.zj.leetcode.module17;

public class No606_ConstructStringFromBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public String tree2str(TreeNode t) {
        StringBuilder stringBuilder = new StringBuilder();
        append(stringBuilder, t);
        return stringBuilder.toString();
    }

    private void append(StringBuilder stringBuilder, TreeNode t) {
        if (t == null) {
            return;
        }
        stringBuilder.append(t.val);
        if (t.left == null && t.right != null) {
            stringBuilder.append("()");
        } else if (t.left != null) {
            stringBuilder.append("(");
            append(stringBuilder, t.left);
            stringBuilder.append(")");
        }
        if (t.right != null) {
            stringBuilder.append("(");
            append(stringBuilder, t.right);
            stringBuilder.append(")");
        }
    }

}
