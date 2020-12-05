package com.cherry.leetcode.tree;

import com.cherry.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: TreeTest
 */
public class TreeTest {

    private static TreeNode mockTree() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        return treeNode;
    }

    @Test
    public void testIssue104() {
        Issue104 issue104 = new Issue104();
        int depth = issue104.maxDepth(TreeTest.mockTree());
        System.out.println(depth);

        depth = issue104.maxDepthBFS(TreeTest.mockTree());
        System.out.println(depth);

        depth = issue104.maxDepthDFS(TreeTest.mockTree());
        System.out.println(depth);
    }

}
