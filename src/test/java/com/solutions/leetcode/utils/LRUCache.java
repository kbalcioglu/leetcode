package com.solutions.leetcode.utils;

import java.util.*;

public class LRUCache {

    static class Node{
        int val;
        int key;
        Node next;
        Node prev;

        Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }

    private Node left;
    private Node right;

    private Map<Integer,Node> cacheMap;
    private int size;

    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        size = capacity;
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node){
        Node prev = right.prev;
        prev.next = node;
        right.prev = node;
        node.prev = prev;
        node.next = right;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)){
            this.remove(cacheMap.get(key));
            this.insert(cacheMap.get(key));
            return cacheMap.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            this.remove(cacheMap.get(key));
        }
        Node node = new Node(key,value);
        cacheMap.put(key,node);
        this.insert(node);

        if(cacheMap.size() > this.size){
            Node lru = left.next;
            this.remove(left.next);
            cacheMap.remove(lru.key);
        }
    }
}
