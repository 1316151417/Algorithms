package com.swust.zj.leetcode.byteDance.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * No_0146
 */
class LRUCache {

    private static class Node {
        int key, value;
        Node pre, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> data;
    private Node first;
    private Node last;

    private void addFirst(Node node) {
        if (first == null) {
            first = node;
            last = node;
        } else {
            Node oldFirst = first;
            oldFirst.pre = node;
            node.next = oldFirst;
            first = node;
        }
    }

    private Node removeNode(Node node) {
        Node nodePre = node.pre;
        Node nodeNext = node.next;
        if (nodePre != null) {
            nodePre.next = nodeNext;
        } else {
            first = nodeNext;
        }
        if (nodeNext != null) {
            nodeNext.pre = nodePre;
        } else {
            last = nodePre;
        }
        node.pre = null;
        node.next = null;
        return node;
    }

    private void access(Node node) {
        removeNode(node);
        addFirst(node);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
    }

    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }
        Node node = data.get(key);
        access(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!data.containsKey(key)) {
            Node node = new Node(key, value);
            data.put(node.key, node);
            addFirst(node);
            if (data.size() > capacity) {
                Node removeNode = removeNode(last);
                data.remove(removeNode.key);
            }
        } else {
            data.get(key).value = value;
            access(data.get(key));
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}