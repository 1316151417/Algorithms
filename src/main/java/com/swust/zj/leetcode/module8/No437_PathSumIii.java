package com.swust.zj.leetcode.module8;

import java.util.*;

public class No437_PathSumIii {

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

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        return backtrack(root, 0, prefixSumMap, targetSum);
    }

    private int backtrack(TreeNode node, int currentSum, Map<Integer, Integer> prefixSumMap, int targetSum) {
        if (node == null) {
            return 0;
        }
        currentSum += node.val;
        int currentResult = prefixSumMap.getOrDefault(currentSum - targetSum, 0);
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        int leftResult = backtrack(node.left, currentSum, prefixSumMap, targetSum);
        int rightResult = backtrack(node.right, currentSum, prefixSumMap, targetSum);
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);
        return currentResult + leftResult + rightResult;
    }

}
