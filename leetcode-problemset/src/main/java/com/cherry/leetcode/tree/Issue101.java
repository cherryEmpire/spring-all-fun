package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: Issue101 Symmetric Tree (本地解法类似 Issue100 )
 */
public class Issue101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compareLR(root.left, root.right);
    }

    private boolean compareLR(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return compareLR(left.left, right.right) && compareLR(left.right, right.left);
    }
}
