package com.swust.zj.leetcode.module23;

public class NoJz68_ErChaShuDeZuiJinGongGongZuXianLcof {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        contains(root, p, q);
        return closedParent;
    }

    private TreeNode closedParent = null;
    private boolean contains(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean leftResult = contains(node.left, p, q);
        boolean rightResult = contains(node.right, p, q);

        if ((leftResult && rightResult) ||
                ((leftResult || rightResult) && (node.val == p.val || node.val == q.val))) {
            closedParent = node;
        }
        return leftResult || rightResult || node.val == p.val || node.val == q.val;
    }
}
