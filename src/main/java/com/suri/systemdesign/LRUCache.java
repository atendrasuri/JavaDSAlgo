package com.suri.systemdesign;

import java.util.HashMap;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
https://leetcode.com/problems/lru-cache/

 */
public class LRUCache {
    public static void main(String[] args) {
       LRUCacheImpl lruCache = new LRUCacheImpl(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));       // returns 1
        lruCache.put(3, 3);    // evicts key 2
        System.out.println(lruCache.get(2));       // returns -1 (not found)
        lruCache.put(4, 4);    // evicts key 1
        System.out.println(lruCache.get(1));       // returns -1 (not found)
        System.out.println(lruCache.get(3));      // returns 3
        System.out.println(lruCache.get(4));

    }
}

class LRUCacheImpl {

    class DNode {
        int key;
        int val;
        DNode prev;
        DNode next;

        DNode() {

        }

        DNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }

    }

    private HashMap<Integer,DNode> map = new HashMap<>();
    private DNode head;
    private DNode tail;
    private int totalItemInCache;
    private int capacity;

    LRUCacheImpl(int capacity) {
        this.totalItemInCache = 0;
        this.capacity = capacity;

        head = new DNode();
        head.prev = null;

        tail = new DNode();
        tail.next = null;

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {

        DNode node = map.get(key);
        if (node == null) {
            DNode newNode = new DNode(key, value);
            map.put(key, newNode);
            addNode(newNode);
            totalItemInCache++;
            if (totalItemInCache > capacity) {
                removeLRUItem();
            }
        } else {
            node.val = value;
            moveToHead(node);
        }

    }

    private void removeLRUItem() {

        LRUCacheImpl.DNode tail = popTail();
        map.remove(tail.key);
        totalItemInCache--;
    }


    private void addNode(LRUCacheImpl.DNode newNode) {

        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }


    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(DNode node) {

        DNode savePrev = node.prev;
        DNode saveNext = node.next;

        savePrev.next = saveNext;
        saveNext.prev = savePrev;
    }


    private DNode popTail() {
        DNode itemBeingRemoved = tail.prev;
        removeNode(itemBeingRemoved);
        return itemBeingRemoved;
    }
}