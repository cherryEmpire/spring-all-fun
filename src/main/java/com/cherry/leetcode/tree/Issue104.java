package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: Issue104 Maximum Depth of Binary Tree
 */
public class Issue104 {
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
        int max = Math.max(maxDepthLeft, maxDepthRight);
        return 0;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int maxDepthBFS(TreeNode root) {
        return 0;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public int maxDepthDFS(TreeNode root) {
        return 0;
    }

}
