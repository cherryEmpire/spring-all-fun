package com.cherry.leetcode.array;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: Issue01 Two Sum
 */
public class Issue01 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}