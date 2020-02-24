package com.swust.zj.leetcode.byteDance.arrayAndSort;

public class No_0060 {

    public String getPermutation(int n, int k) {
        return recursive(n, k, new boolean[n]);
    }

    private String recursive(int n, int k, boolean[] visited) {
        int perGroupCount = factorial(n - 1);
        int offset = k % perGroupCount;
        int groupIndex = k / perGroupCount + (offset > 0 ? 1 : 0);
        int minNum = 0;
        for (; minNum < visited.length && groupIndex > 0; minNum++) {
            if (!visited[minNum]) {
                groupIndex--;
            }
        }
        visited[minNum - 1] = true;
        if (n == 1) {
            return String.valueOf(minNum);
        } else {
            return String.valueOf(minNum) + recursive(n - 1, offset == 0 ? perGroupCount : offset, visited);
        }
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new No_0060().getPermutation(3, 3));
    }
}
