package com.cherry.leetcode.linkedlist;

import java.lang.reflect.Method;

/**
 * @Author: Cherry
 * @Date: 2020/12/10
 * @Desc: Issue707
 */
public class Issue707 {

    public static void main(String[] args) {
        String[] operations = new String[]{"MyLinkedList", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtTail",
                "addAtTail", "addAtTail", "deleteAtIndex", "addAtHead", "addAtHead", "get",
                "addAtTail", "addAtHead", "get", "addAtTail", "addAtIndex", "addAtTail",
                "addAtHead", "addAtHead", "addAtHead", "get", "addAtIndex", "addAtHead",
                "get", "addAtHead", "deleteAtIndex", "addAtHead", "addAtTail", "addAtTail",
                "addAtIndex", "addAtTail", "addAtHead", "get", "addAtTail", "deleteAtIndex",
                "addAtIndex", "deleteAtIndex", "addAtHead", "addAtTail", "addAtHead", "addAtHead",
                "addAtTail", "addAtTail",
                "get", "get", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtIndex", "get", "addAtHead", "addAtIndex", "addAtHead", "addAtTail", "addAtTail", "addAtIndex", "deleteAtIndex", "addAtIndex", "addAtHead", "addAtHead", "deleteAtIndex", "addAtTail", "deleteAtIndex", "addAtIndex", "addAtTail", "addAtHead", "get", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtHead", "addAtHead", "addAtHead", "addAtHead", "deleteAtIndex", "get", "get", "addAtHead", "get", "addAtTail", "addAtTail", "addAtIndex", "addAtIndex", "addAtHead", "addAtTail", "addAtTail", "get", "addAtIndex", "addAtHead", "deleteAtIndex", "addAtTail", "get", "addAtHead", "get", "addAtHead", "deleteAtIndex", "get", "addAtTail", "addAtTail"};
        int[][] nums = new int[][]{{}, {38}, {66}, {61}, {76}, {26}, {37}, {8}, {5}, {4}, {45}, {4}, {85}, {37}, {5}, {93}, {10, 23}, {21}, {52}, {15}, {47}, {12}, {6, 24}, {64}, {4}, {31}, {6}, {40}, {17}, {15}, {19, 2}, {11}, {86}, {17}, {55}, {15}, {14, 95}, {22}, {66}, {95}, {8}, {47}, {23}, {39}, {30}, {27}, {0}, {99}, {45}, {4}, {9, 11}, {6}, {81}, {18, 32}, {20}, {13}, {42}, {37, 91}, {36}, {10, 37}, {96}, {57}, {20}, {89}, {18}, {41, 5}, {23}, {75}, {7}, {25, 51}, {48}, {46}, {29}, {85}, {82}, {6}, {38}, {14}, {1}, {12}, {42}, {42}, {83}, {13}, {14, 20}, {17, 34}, {36}, {58}, {2}, {38}, {33, 59}, {37}, {15}, {64}, {56}, {0}, {40}, {92}, {63}, {35}, {62}, {32}};

        Integer[] results = {null, null, null, null, null, null, null, null, null, null, null, 61, null, null, 61, null, null, null, null, null, null, 85, null, null, 37, null, null, null, null, null, null, null, null, 23, null, null, null, null, null, null, null, null, null, null, -1, 95, null, null, null, null, null, 31, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8, null, null, null, null, null, null, null, null, null, 6, 47, null, 23, null, null, null, null, null, null, null, 93, null, null, null, null, 48, null, 93, null, null, 59, null, null};


        MyLinkedList myLinkedList = new MyLinkedList();
        Class<? extends MyLinkedList> myLinkedListClass = myLinkedList.getClass();
        for (int i = 1; i < operations.length; i++) {
            String operation = operations[i];
            Method method = Issue707.getMethod(myLinkedListClass, operation);
            if (method == null) {
                throw new RuntimeException("获取方法错误");
            }
            int[] num = nums[i];
            Object result = null;
            try {
                if (num.length == 0) {
                    result = method.invoke(myLinkedList);
                }
                if (num.length == 1) {
                    result = method.invoke(myLinkedList, num[0]);
                } else {
                    result = method.invoke(myLinkedList, num[0], num[1]);
                }
            } catch (Exception e) {
                throw new RuntimeException("执行方法错误");
            }
            if (results[i] != null && Integer.valueOf(results[i].toString()) - Integer.valueOf(result.toString()) != 0) {
                System.out.println(i + "##" + result);
            }
        }
        System.out.println("END");
    }

    public static Method getMethod(Class<? extends MyLinkedList> classObj, String methodName) {
        try {
            Method method = null;
            if (methodName.equals("get")) {
                method = classObj.getMethod("get", int.class);
            }
            if (methodName.equals("addAtHead")) {
                method = classObj.getMethod("addAtHead", int.class);
            }
            if (methodName.equals("addAtTail")) {
                method = classObj.getMethod("addAtTail", int.class);
            }
            if (methodName.equals("addAtIndex")) {
                method = classObj.getMethod("addAtIndex", int.class, int.class);
            }
            if (methodName.equals("deleteAtIndex")) {
                method = classObj.getMethod("deleteAtIndex", int.class);
            }
            return method;

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

/**
 * 链表实现（线程不安全，多线程下操作同一链表需要加锁）
 */
class MyLinkedList {

    private int size;

    private ListNode head;

    private ListNode tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = getNode(index);
        if (node == null) {
            return -1;
        } else {
            return node.val;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) return;

        if (index < 0) index = 0;

        ListNode currentNode = head;
        if (index + 1 < size - index)
            for (int i = 0; i < index + 1; ++i) currentNode = currentNode.next;
        else {
            currentNode = tail;
            for (int i = 0; i < size - index; ++i) currentNode = currentNode.pre;
        }

        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.next = currentNode;
        toAdd.pre = currentNode.pre;
        currentNode.pre.next = toAdd;
        currentNode.pre = toAdd;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        ListNode delNode = getNode(index);
        if (delNode == null) {
            return;
        }
        delNode.pre.next = delNode.next;
        delNode.next.pre = delNode.pre;
        size--;
    }

    private ListNode getNode(int index) {
        if (index < 0 || index >= size) return null;
        ListNode currentNode = head;
        if (index + 1 < size - index)
            for (int i = 0; i < index + 1; ++i) currentNode = currentNode.next;
        else {
            currentNode = tail;
            for (int i = 0; i < size - index; ++i) currentNode = currentNode.pre;
        }
        return currentNode;
    }

}

class ListNode {
    public int val;

    public ListNode pre;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
