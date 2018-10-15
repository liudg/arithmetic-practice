package com.liudong.dataStruct;

/**
 * 基于链表的队列实现
 */

public class QueueBasedOnLinkedList {

    // 队列的队首和队尾
    private SinglyLinkedList.Node head = null;
    private SinglyLinkedList.Node tail = null;

    public void enqueue(int value) {
        SinglyLinkedList.Node newNode = SinglyLinkedList.createNode(value);
        if(tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public int dequeue() {
        if(head == null) return -1;
        int value = head.getData();
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        SinglyLinkedList.Node p = head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }
}