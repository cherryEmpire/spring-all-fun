package com.cherry.leetcode.offer;

/**
 * @Author: Cherry
 * @Date: 2020/12/17
 * @Desc: Issue40 最小的k个数
 */
public class Issue40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int length = arr.length;
        if (k >= length) {
            return arr;
        }
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        int[] arrnew = new int[k];
        for (int i = 0; i < k; i++) {
            arrnew[i] = arr[i];
        }
        return arrnew;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = doSort(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private int doSort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int x = arr[low];
        while (i < j) {
            while (arr[j] >= x && i < j) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (arr[i] < x && i < j) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = x;
        return i;
    }

}
