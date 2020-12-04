package com.cherry.leetcode.common;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: ListNode
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
