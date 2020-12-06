package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: Issue107 Binary Tree Level Order Traversal II
 */
public class Issue107 {
    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> visit = new LinkedList<>();
        visit.add(root);
        while (!visit.isEmpty()) {
            int size = visit.size();
            List<Integer> levelList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode element = visit.remove();
                if (element.left != null) {
                    visit.add(element.left);
                }
                if (element.right != null) {
                    visit.add(element.right);
                }
                levelList.add(element.val);
            }
            result.add(levelList);
        }
        if (!result.isEmpty()) {
            Collections.reverse(result);
        }
        return result;
    }
}
