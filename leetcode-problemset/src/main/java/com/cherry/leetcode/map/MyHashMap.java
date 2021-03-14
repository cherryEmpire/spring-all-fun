package com.cherry.leetcode.map;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: Cherry
 * @Date: 2021/3/14
 * @Desc: MyHashMap 706. 设计哈希映射
 */
public class MyHashMap {

    class Entry {
        private int key;
        private int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private LinkedList<Entry>[] datas;

    private static final int DEFAULT_SIZE = 769;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        datas = new LinkedList[DEFAULT_SIZE];
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            datas[i] = new LinkedList<>();
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = hash(key);
        Iterator<Entry> iterator = datas[index].iterator();
        while (iterator.hasNext()) {
            Entry next = iterator.next();
            if (next.getKey() == key) {
                next.setValue(value);
                return;
            }
        }
        datas[index].offerLast(new Entry(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = hash(key);
        Iterator<Entry> iterator = datas[index].iterator();
        while (iterator.hasNext()) {
            Entry next = iterator.next();
            if (next.getKey() == key) {
                return next.getValue();
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = hash(key);
        Iterator<Entry> iterator = datas[index].iterator();
        while (iterator.hasNext()) {
            Entry next = iterator.next();
            if (next.getKey() == key) {
                datas[index].remove(next);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % DEFAULT_SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
