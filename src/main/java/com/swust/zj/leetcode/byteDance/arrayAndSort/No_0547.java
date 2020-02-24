package com.swust.zj.leetcode.byteDance.arrayAndSort;

public class No_0547 {

    public int findCircleNum(int[][] M) {
        int count = 0;
        for (int x = 0; x < M.length; x++) {
            count += dfs(M, x);
        }
        return count;
    }

    private int dfs(int[][] M, int x) {
        int result = 0;
        if (M[x][x] == 1) {
            result = 1;
        }
        for (int y = 0; y < M[x].length; y++) {
            if (M[x][y] == 1) {
                M[x][y] = 0;
                dfs(M, y);
                result = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new No_0547().findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }
}
