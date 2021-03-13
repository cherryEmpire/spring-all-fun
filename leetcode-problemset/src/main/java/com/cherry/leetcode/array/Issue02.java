package com.cherry.leetcode.array;

import com.cherry.leetcode.common.ListNode;

/**
 * @Author: Cherry
 * @Date: 2020/12/5
 * @Desc: Issue02 Add Two Numbers
 */
public class Issue02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = listNode;
        int add = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = add + x + y;
            add = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (add > 0) {
            current.next = new ListNode(add);
        }
        return listNode.next;
    }
}
