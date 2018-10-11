package com.liudong;

import com.liudong.arithmetic.LinkedListAlgo;
import com.liudong.dataStruct.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        testSinglyLinkedList();
        linkedListReverse();
        linkedListCheckCircle();
        linkedListMerge();
    }

    //单链表测试
    private static void testSinglyLinkedList() {
        System.out.println("==========单链表start==========");
        SinglyLinkedList.Node head = SinglyLinkedList.createNode(1);
        SinglyLinkedList.Node node2 = SinglyLinkedList.createNode(2);
        SinglyLinkedList.Node node3 = SinglyLinkedList.createNode(3);
        SinglyLinkedList.Node node4 = SinglyLinkedList.createNode(4);
        SinglyLinkedList.Node node5 = SinglyLinkedList.createNode(5);
        SinglyLinkedList.Node node6 = SinglyLinkedList.createNode(6);

        SinglyLinkedList slIns = new SinglyLinkedList();
        slIns.insertToHead(head);
        slIns.insertAfter(head, node2);
        slIns.insertAfter(node2, node3);
        slIns.insertAfter(node3, node4);
        slIns.insertAfter(node4, node5);
        slIns.insertBefore(node5, node6);
        slIns.printAll();
        System.out.println("查找结果：" + slIns.findByIndex(2).getData() + "---" + slIns.findByValue(2).getData());
        slIns.deleteByNode(node6);
        slIns.deleteByValue(1);
        slIns.printAll();
        System.out.println("==========单链表end==========\n");
    }

    //链表反转
    private static void linkedListReverse() {
        System.out.println("==========单链表反转start==========");
        SinglyLinkedList.Node head = SinglyLinkedList.createNode(1);
        SinglyLinkedList.Node node2 = SinglyLinkedList.createNode(2);
        SinglyLinkedList.Node node3 = SinglyLinkedList.createNode(3);
        SinglyLinkedList.Node node4 = SinglyLinkedList.createNode(4);
        SinglyLinkedList.Node node5 = SinglyLinkedList.createNode(5);
        SinglyLinkedList.Node node6 = SinglyLinkedList.createNode(6);

        SinglyLinkedList slIns = new SinglyLinkedList();
        slIns.insertToHead(head);
        slIns.insertAfter(head, node2);
        slIns.insertAfter(node2, node3);
        slIns.insertAfter(node3, node4);
        slIns.insertAfter(node4, node5);
        slIns.insertAfter(node5, node6);
        System.out.print("原始链表：");
        slIns.printAll();
        SinglyLinkedList.Node newNode = LinkedListAlgo.reverse(head);
        SinglyLinkedList slIns1 = new SinglyLinkedList();
        slIns1.insertToHead(newNode);
        System.out.print("反转链表：");
        slIns1.printAll();
        System.out.println("==========单链表反转end==========\n");
    }

    //链表中环检测
    private static void linkedListCheckCircle() {
        System.out.println("==========链表中环start==========");
        SinglyLinkedList.Node head = SinglyLinkedList.createNode(1);
        SinglyLinkedList.Node node2 = SinglyLinkedList.createNode(2);
        SinglyLinkedList.Node node3 = SinglyLinkedList.createNode(3);
        SinglyLinkedList.Node node4 = SinglyLinkedList.createNode(4);
        SinglyLinkedList.Node node5 = SinglyLinkedList.createNode(5);
        SinglyLinkedList.Node node6 = SinglyLinkedList.createNode(6);

        SinglyLinkedList slIns = new SinglyLinkedList();
        slIns.insertToHead(head);
        slIns.insertAfter(head, node2);
        slIns.insertAfter(node2, node3);
        slIns.insertAfter(node3, node4);
        slIns.insertAfter(node4, node5);
        slIns.insertAfter(node5, node6);
        System.out.print("原始链表：");
        slIns.printAll();
        node6.next = node3; //形成环
        System.out.println("是否有中环节点：" + LinkedListAlgo.checkCircle(head));
        System.out.println("==========链表中环end==========\n");
    }

    //两个有序链表的合并
    private static void linkedListMerge() {
        System.out.println("==========链表合并start==========");
        SinglyLinkedList.Node head1 = SinglyLinkedList.createNode(1);
        SinglyLinkedList.Node node2 = SinglyLinkedList.createNode(5);
        SinglyLinkedList.Node node3 = SinglyLinkedList.createNode(6);
        SinglyLinkedList slIns = new SinglyLinkedList();
        slIns.insertToHead(head1);
        slIns.insertAfter(head1, node2);
        slIns.insertAfter(node2, node3);
        System.out.print("链表1：");
        slIns.printAll();

        SinglyLinkedList.Node head2 = SinglyLinkedList.createNode(4);
        SinglyLinkedList.Node node5 = SinglyLinkedList.createNode(7);
        SinglyLinkedList.Node node6 = SinglyLinkedList.createNode(8);
        SinglyLinkedList slIns1 = new SinglyLinkedList();
        slIns1.insertToHead(head2);
        slIns1.insertAfter(head2, node5);
        slIns1.insertAfter(node5, node6);
        System.out.print("链表2：");
        slIns1.printAll();

        SinglyLinkedList.Node newNode = LinkedListAlgo.mergeLinkedList(head1, head2);
        SinglyLinkedList slIns3 = new SinglyLinkedList();
        slIns3.insertToHead(newNode);
        System.out.print("合并结果：");
        slIns3.printAll();
        System.out.println("==========链表合并end==========\n");
    }
}
