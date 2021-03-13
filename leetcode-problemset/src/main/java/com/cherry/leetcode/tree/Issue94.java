package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: Issue94 Binary Tree Inorder Traversal
 */
public class Issue94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        if (left != null) {
            traversal(left, list);
        }
        list.add(root.val);
        TreeNode right = root.right;
        if (right != null) {
            traversal(right, list);
        }
    }
}
