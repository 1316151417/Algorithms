package com.swust.zj.leetcode.module10;

public class No155_MinStack {

    static class MinStack {
        static class Node {
            int val;
            int min;
            Node next;
            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
        private Node head;
        public MinStack() {
        }
        public void push(int val) {
            head = head == null ?
                    new Node(val, val, null) :
                    new Node(val, val < head.min ? val : head.min, head);
        }
        public void pop() {
            head = head.next;
        }
        public int top() {
            return head.val;
        }
        public int getMin() {
            return head.min;
        }
    }

}
