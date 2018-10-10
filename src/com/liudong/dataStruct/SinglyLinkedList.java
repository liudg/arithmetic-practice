package com.liudong.dataStruct;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 * 3）参考：https://github.com/wangzheng0822/algo/blob/master/java/06_linkedlist/SinglyLinkedList.java
 */

public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (head != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (head != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }

    public void insertToHead(int value) {}

    public void insertToHead(Node newNode) {}

    public void insertAfter(Node p, int value) {}

    public void insertAfter(Node p, Node newNode) {}

    public void insertBefore(Node p, int value) {}

    public void insertBefore(Node p, Node newNode) {}

    public void deleteByNode(Node p) {}

    public void deleteByValue(int value) {}

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
