package com.swust.zj.leetcode.module7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No103_BinaryTreeZigzagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) {
            queue.add(root);
        }
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.poll());
            }
            for (TreeNode node : nodeList) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            List<Integer> subResultList = new ArrayList<>();
            if (leftToRight) {
                for (int i = 0; i < nodeList.size(); i++) {
                    subResultList.add(nodeList.get(i).val);
                }
            } else {
                for (int i = nodeList.size() - 1; i >= 0; i--) {
                    subResultList.add(nodeList.get(i).val);
                }
            }
            resultList.add(subResultList);
            leftToRight = leftToRight == true ? false : true;
        }
        return resultList;
    }

}
