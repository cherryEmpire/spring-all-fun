package com.cherry.leetcode.array;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: Issue26 Remove Duplicates from Sorted Array
 */
public class Issue26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int currentValue = nums[0];
        for (int i = 0, len = nums.length; i < len; i++) {
            int num = nums[i];
            if (currentValue == num) {
                continue;
            }
            index++;
            nums[index] = num;
            currentValue = num;
        }
        return index + 1;
    }

}
