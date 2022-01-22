package com.cherry.leetcode.offer;

import java.util.ArrayDeque;

/**
 * @Author: Cherry
 * @Date: 2021/3/27
 * @Desc: Issue64
 * <p>
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Issue64 {

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sum(20) - 1);
    }

    public int test() {
        int x1 = 3;
        int y1 = 3;
        int xk = 0;
        int yk = 0;
        int x2 = 0;
        int y2 = 0;
        int i = 1;
        while (x2 != 3 && y2 != 3) {
            String ship = i % 2 == 1 ? "船从左到右" : "";
            System.out.printf("第%d次,%s，左岸商人%d仆人%d，->>船上商人%d仆人%d，右岸商人%d仆人%d", ship, i, x1, y1, xk, yk, x2, y2);

        }
        return -1;
    }

    public static double sum(int i) {
        if (i == 0) {
            return 1;
        }
        return sum(i - 1) * 1.075 + 1;
    }

    // 邻接矩阵表示无向图
    private int data[][] = {
            {0, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0}
    };

    private int indexX = 0;

    private int indexY = 0;

    public void findPath(int maxDepth, int start, int end) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        dfs(maxDepth, queue, start, end);
    }

    public void dfs(int maxDepth, ArrayDeque<Integer> queue, int start, int end) {
        if (data[indexX][indexY] == 1 && queue.contains(indexX)) {
            if (queue.size() <= maxDepth) {
                if (queue.getFirst() == start && queue.getLast() == end) {
                    // 输出结果集
                    System.out.println(queue);
                    queue.removeLast();
                    dfs(maxDepth, queue, start, end);
                } else {
                    queue.add(indexX);
                }
            } else {
                // 回溯
                queue.removeLast();
                indexX--;
                indexY++;
                dfs(maxDepth, queue, start, end);
            }
        }
        indexY++;
    }

    public void init(int size, String[] graph) {

    }

}
