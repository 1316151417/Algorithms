package com.swust.zj.leetcode.byteDance.dataStructure;

import java.util.Stack;

/**
 * No_0155
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x) {
        stack.add(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.add(x);
        }
    }
    public void pop() {
        int pop = stack.pop();
        if(pop == minStack.peek()) {
            minStack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}