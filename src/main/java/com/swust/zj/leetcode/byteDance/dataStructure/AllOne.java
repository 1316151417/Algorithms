package com.swust.zj.leetcode.byteDance.dataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    private static class Node {
        int count;
        Set<String> keySet;
        Node pre, next;
        Node(int count) {
            this.count = count;
            keySet = new HashSet<>();
        }
    }
    private Node first;
    private Node last;
    private Map<String, Integer> keyCountMap;
    private Map<Integer, Node> countNodeMap;
    public AllOne() {
        first = new Node(Integer.MIN_VALUE);
        last = new Node(Integer.MAX_VALUE);
        first.next = last;
        last.pre = first;
        keyCountMap = new HashMap<>();
        countNodeMap = new HashMap<>();
    }
    private void addNodeAfter(Node newNode, Node preNode) {
        Node nextNode = preNode.next;
        preNode.next = newNode;
        newNode.pre = preNode;
        newNode.next = nextNode;
        nextNode.pre = newNode;
    }
    private void removeKeyFromNode(Node node, String key) {
        node.keySet.remove(key);
        if (node.keySet.isEmpty()) {
            Node preNode = node.pre;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
            node.pre = null;
            node.next = null;
            countNodeMap.remove(node.count);
        }
    }
    private void changeKey(String key, int offset) {
        Integer count = keyCountMap.get(key);
        Node node = countNodeMap.get(count);
        count += offset;
        keyCountMap.put(key, count);
        Node newNode;
        if (countNodeMap.containsKey(count)) {
            newNode = countNodeMap.get(count);
        } else {
            newNode = new Node(count);
            addNodeAfter(newNode, offset == 1 ? node : node.pre);
            countNodeMap.put(count, newNode);
        }
        newNode.keySet.add(key);
        removeKeyFromNode(node, key);
    }
    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyCountMap.put(key, 1);
            if (first.next.count != 1) {
                addNodeAfter(new Node(1), first);
            }
            first.next.keySet.add(key);
            countNodeMap.put(1, first.next);
        }
    }
    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) {
            return;
        }
        Integer count = keyCountMap.get(key);
        if (count == 1) {
            keyCountMap.remove(key);
            removeKeyFromNode(countNodeMap.get(count), key);
        } else {
            changeKey(key, -1);
        }
    }
    public String getMaxKey() {
        return last.pre == first ? "" : last.pre.keySet.iterator().next();
    }
    public String getMinKey() {
        return first.next == last ? "" : first.next.keySet.iterator().next();
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");
        allOne.dec("hello");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        System.out.println(allOne.getMaxKey());
    }
}