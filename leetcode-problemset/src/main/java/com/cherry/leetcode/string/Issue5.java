package com.cherry.leetcode.string;

/**
 * @Author: Cherry
 * @Date: 2021/3/14
 * @Desc: Issue5
 */
public class Issue5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String result = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; i + j < length; j++) {
                int k = i + j;
                if (i == 0) {
                    dp[j][k] = true;
                } else if (i == 1) {
                    dp[j][k] = s.charAt(j) == s.charAt(k);
                } else {
                    dp[j][k] = s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1];
                }
                if (dp[j][k] && i + 1 > result.length()) {
                    result = s.substring(j, i + j + 1);
                }
            }
        }
        return result;
    }
}
