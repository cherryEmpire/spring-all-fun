package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

/**
 * @Author: Cherry
 * @Date: 2020/12/12
 * @Desc: Issue112 Path Sum
 */
public class Issue112 {

    private boolean hasPathSum = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null || hasPathSum == true) {
            return hasPathSum;
        }
        sum = sum - root.val;
        // is leaf node.
        if (sum == 0 && root.left == null && root.right == null) {
            hasPathSum = true;
        }
        hasPathSum(root.left, sum);
        hasPathSum(root.right, sum);
        sum += root.val;
        return hasPathSum;
    }
}
