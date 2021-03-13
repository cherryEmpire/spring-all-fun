package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: Issue104 Maximum Depth of Binary Tree
 */
public class Issue104 {
    private int maxLevel = 0;

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepthLeft = maxDepth(root.left);
        int maxDepthRight = maxDepth(root.right);
        return Math.max(maxDepthLeft, maxDepthRight) + 1;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> visit = new LinkedList<>();
        int level = 0;
        visit.add(root);
        while (!visit.isEmpty()) {
            int size = visit.size();
            for (int i = 0; i < size; i++) {
                TreeNode element = visit.remove();
                if (element.left != null) {
                    visit.add(element.left);
                }
                if (element.right != null) {
                    visit.add(element.right);
                }
            }
            level++;
        }
        return level;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return maxLevel;
    }

    private int dfs(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }
        if (level > maxLevel) {
            maxLevel = new Integer(level);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

        return maxLevel;
    }

}
