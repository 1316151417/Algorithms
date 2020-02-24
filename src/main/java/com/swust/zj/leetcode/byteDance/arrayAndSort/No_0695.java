package com.swust.zj.leetcode.byteDance.arrayAndSort;

public class No_0695 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int area = area(grid, i, j);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public int area(int[][] grid, int x, int y) {
        int count = 0;
        if (grid[x][y] == 0) {
            return count;
        }
        count++;
        //模拟上下左右
        grid[x][y] = 0;
        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
            count += area(grid, x - 1, y);
        }
        if (x + 1 < grid.length && grid[x + 1][y] == 1) {
            count += area(grid, x + 1, y);
        }
        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
            count += area(grid, x, y - 1);
        }
        if (y + 1 < grid[x].length && grid[x][y + 1] == 1) {
            count += area(grid, x, y + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new No_0695().maxAreaOfIsland(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}));
    }
}
