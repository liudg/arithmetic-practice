package com.liudong.dataStruct;

/**
 * 基于链表实现的栈---链式栈
 */

public class StackBasedOnLinkedList {
    private SinglyLinkedList.Node top = null;

    public void push(int value) {
        SinglyLinkedList.Node newNode = SinglyLinkedList.createNode(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) return -1;
        int value = top.getData();
        top = top.next;
        return value;
    }

    public void printAll() {
        SinglyLinkedList.Node p = top;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }
}
