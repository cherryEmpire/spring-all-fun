package com.cherry.leetcode.array;

import java.util.PriorityQueue;

/**
 * @Author: Cherry
 * @Date: 2021/2/11
 * @Desc: Issue703
 */
public class Issue703 {
}

class KthLargest {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
