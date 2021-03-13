package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

/**
 * @Author: Cherry
 * @Date: 2021/3/6
 * @Desc: Issue98
 */
public class Issue98 {

    private TreeNode mid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (mid != null && root.val <= mid.val) {
            return false;
        }
        mid = root;
        return isValidBST(root.right);
    }
}
