package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: Issue100 Same Tree
 */
public class Issue100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
