package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: Issue111 Minimum Depth of Binary Tree
 */
public class Issue111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        } else {
            return 1 + minDepth(root.left);
        }
    }
}
