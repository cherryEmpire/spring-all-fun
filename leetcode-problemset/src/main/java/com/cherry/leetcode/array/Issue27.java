package com.cherry.leetcode.array;

/**
 * @Author: Cherry
 * @Date: 2020/12/17
 * @Desc: Issue27 Remove Element
 */
public class Issue27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int end = 0;
        for (int i = 0, length = nums.length; i < length; i++) {
            if (nums[i] != val) {
                nums[end++] = nums[i];
            }
        }
        return end;
    }
}
