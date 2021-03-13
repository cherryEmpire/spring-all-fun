package com.cherry.leetcode.string;

/**
 * @Author: Cherry
 * @Date: 2021/3/14
 * @Desc: Solution
 */
public class Solution {

    public int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        int index = chars.length - 1;
        int counti = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                counti++;
            }
        }
        while (counti > 0) {
            if (chars[index] == '0') {
                index--;
            } else {
                counti--;
                chars[index] = '0';
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("011100"));
    }
}
