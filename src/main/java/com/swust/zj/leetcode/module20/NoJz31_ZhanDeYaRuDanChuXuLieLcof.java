package com.swust.zj.leetcode.module20;

import java.util.Stack;

public class NoJz31_ZhanDeYaRuDanChuXuLieLcof {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < pushed.length && j < popped.length) {
            while (i < pushed.length) {
                if (pushed[i] == popped[j]) {
                    stack.push(pushed[i++]);
                    break;
                }
                stack.push(pushed[i++]);
            }
            while (j < popped.length && !stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }

}
