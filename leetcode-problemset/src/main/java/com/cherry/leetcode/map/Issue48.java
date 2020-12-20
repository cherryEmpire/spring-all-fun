package com.cherry.leetcode.map;

/**
 * @Author: Cherry
 * @Date: 2020/12/19
 * @Desc: Issue48 48. 旋转图像
 */
public class Issue48 {

    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] res = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Issue48 issue48 = new Issue48();
        issue48.rotate(res);
    }
}
