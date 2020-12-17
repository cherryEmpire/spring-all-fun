package com.cherry.leetcode.string;

/**
 * @Author: Cherry
 * @Date: 2020/12/17
 * @Desc: Issue28 Implement strStr()
 */
public class Issue28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        char[] hayArray = haystack.toCharArray();
        char[] needArray = needle.toCharArray();
        int hayArrayLen = hayArray.length;
        int needArrayLen = needArray.length;
        if (hayArrayLen < needArrayLen) {
            return -1;
        }
        for (int i = 0; i <= hayArrayLen - needArrayLen; i++) {
            if (checkStr(hayArray, needArray, i, needArrayLen) == true) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkStr(char[] hayArray, char[] needArray, int i, int needArrayLen) {
        for (int j = i, k = 0; k < needArrayLen; j++, k++) {
            if (hayArray[j] != needArray[k]) {
                return false;
            }
        }
        return true;
    }
}
