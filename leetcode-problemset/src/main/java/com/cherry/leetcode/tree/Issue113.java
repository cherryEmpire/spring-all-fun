package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Cherry
 * @Date: 2020/12/12
 * @Desc: Issue113 Path Sum II
 */
public class Issue113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Integer> visit = new LinkedList<>();
        dfs(root, sum, visit, result);
        return result;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> visit, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        int val = root.val;
        visit.addLast(val);
        sum = sum - val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(visit));
        }
        dfs(root.left, sum, visit, result);
        dfs(root.right, sum, visit, result);
        visit.removeLast();
    }
}
