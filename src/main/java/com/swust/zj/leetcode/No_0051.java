package com.swust.zj.leetcode;

public class No_0051 {
    public static void main(String[] args) {
        System.out.println(new No_0051().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        int[][] data = new int[n][n];
        backtrack(n, data, 0);
        return count;
    }

    public int count;

    public void backtrack(int n, int[][] data, int row) {
        if (row >= n) {
            count++;
            return;
        }
        for (int column = 0; column < n; column++) {
            if (judge(n, data, row, column)) {
                data[row][column] = 1;
                backtrack(n, data, row + 1);
                data[row][column] = 0;
            }
        }
    }

    public boolean judge(int n, int[][] data, int row, int column) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 1) {
                    if (i == row || j == column) {
                        return false;
                    }
                    double x1 = i + 1, y1 = j + 1, x2 = row + 1, y2 = column + 1;
                    double k = (y2 - y1) / (x2 - x1);
                    if (Math.abs(k) == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
