package com.swust.zj.leetcode.module8;

import java.util.ArrayList;
import java.util.List;

public class No113_PathSumIi {

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), resultList);
        return resultList;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> resultList) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            resultList.add(new ArrayList<>(temp));
        }
        dfs(root.left, targetSum, temp, resultList);
        dfs(root.right, targetSum, temp, resultList);
        temp.remove(temp.size() - 1);
    }
    
}
