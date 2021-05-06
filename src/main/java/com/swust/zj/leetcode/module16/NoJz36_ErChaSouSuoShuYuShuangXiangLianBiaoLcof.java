package com.swust.zj.leetcode.module16;

public class NoJz36_ErChaSouSuoShuYuShuangXiangLianBiaoLcof {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {
        }
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        middleOrderAddTail(root);
        connectHeadAndTail();
        return head;
    }

    private Node head;
    private Node tail;

    private void middleOrderAddTail(Node node) {
        if (node == null) {
            return;
        }
        middleOrderAddTail(node.left);
        if (head == null) {
            head = node;
        }
        if (tail == null) {
            tail = node;
        } else {
            tail.right = node;
            node.left = tail;
            tail = node;
        }
        middleOrderAddTail(node.right);
    }

    private void connectHeadAndTail() {
        tail.right = head;
        head.left = tail;
    }

}
