package com.liudong;

import com.liudong.dataStruct.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        testSinglyLinkedList();
    }

    //单链表测试
    private static void testSinglyLinkedList(){
        System.out.println("==========单链表start==========");
        SinglyLinkedList.Node node1 = SinglyLinkedList.createNode(1);
        SinglyLinkedList.Node node2 = SinglyLinkedList.createNode(2);
        SinglyLinkedList.Node node3 = SinglyLinkedList.createNode(3);
        SinglyLinkedList.Node node4 = SinglyLinkedList.createNode(4);
        SinglyLinkedList.Node node5 = SinglyLinkedList.createNode(5);
        SinglyLinkedList.Node node6 = SinglyLinkedList.createNode(6);

        SinglyLinkedList slIns = new SinglyLinkedList();
        slIns.insertToHead(node1);
        slIns.insertAfter(node1, node2);
        slIns.insertAfter(node2, node3);
        slIns.insertAfter(node3, node4);
        slIns.insertAfter(node4, node5);
        slIns.insertBefore(node5, node6);
        slIns.printAll();
        System.out.println("查找结果：" + slIns.findByIndex(2).getData() + "---" + slIns.findByValue(2).getData());
        slIns.deleteByNode(node6);
        slIns.deleteByValue(1);
        slIns.printAll();
        System.out.println("==========单链表end==========");
    }
}
