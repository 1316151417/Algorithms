package com.swust.zj.leetcode.module10;

import java.util.Stack;

public class NoJz09_YongLiangGeZhanShiXianDuiLieLcof {

    static class CQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();
        public CQueue() {
        }
        public void appendTail(int value) {
            stack1.push(value);
        }
        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            return -1;
        }
    }

}
