package com.liudong;

import com.liudong.arithmetic.AlgoExample;
import com.liudong.arithmetic.CountingSort;
import com.liudong.arithmetic.LinkedListAlgo;
import com.liudong.arithmetic.QuickSort;
import com.liudong.dataStruct.CircularQueue;
import com.liudong.dataStruct.SinglyLinkedList;
import com.liudong.dataStruct.StackBasedOnArray;
import com.liudong.dataStruct.StackBasedOnLinkedList;

public class Main {

    public static void main(String[] args) {
        //链表操作
        testSinglyLinkedList();
        linkedListReverse();
        linkedListCheckCircle();
        linkedListMerge();
        deleteNode();
        centerNode();
        //栈操作
        testArrayStack();
        testLinkedStack();
        //队列操作
        circularQueue();
        //排序
        sorts();
        //算法例子
        findRankKEle();
        //计数排序
        countingSort();
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
//        node6.next = node3; //形成环
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

    //删除链表倒数第n个节点
    private static void deleteNode() {
        System.out.println("==========删除链表节点start==========");
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
        SinglyLinkedList.Node newNode = LinkedListAlgo.deleteNode(head, 3);
        SinglyLinkedList slIns1 = new SinglyLinkedList();
        slIns1.insertToHead(newNode);
        System.out.print("删除后：");
        slIns1.printAll();
        System.out.println("==========删除链表节点end==========\n");
    }

    //链表中间节点
    private static void centerNode() {
        System.out.println("==========链表中间节点start==========");
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
        SinglyLinkedList.Node newNode = LinkedListAlgo.centerNode(head);
        System.out.println("中间节点：" + newNode.getData());
        System.out.println("==========链表中间节点end==========\n");
    }

    //测试数组栈
    private static void testArrayStack() {
        System.out.println("==========数组栈start==========");
        StackBasedOnArray stack = new StackBasedOnArray(6);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        System.out.println("栈数据：['a', 'b', 'c', 'd', 'e', 'f']");
        stack.pop();
        System.out.print("出栈：");
        stack.printAll();
        stack.push("R");
        System.out.print("入栈R：");
        stack.printAll();
        System.out.println("==========数组栈end==========\n");
    }

    //测试链式栈
    private static void testLinkedStack() {
        System.out.println("==========链式栈start==========");
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.print("栈数据：");
        stack.printAll();

        stack.pop();
        System.out.print("出栈：");
        stack.printAll();
        stack.push(6);
        System.out.print("入栈6：");
        stack.printAll();
        System.out.println("==========链式栈end==========\n");
    }

    //循环队列测试
    private static void circularQueue() {
        System.out.println("==========循环队列start==========");
        CircularQueue queue = new CircularQueue(6);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        System.out.print("队列数据：");
        queue.printAll();
        System.out.println("队列满时入队结果：" + queue.enqueue("1"));
        System.out.print("出队3次：");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printAll();
        System.out.print("入队3次：");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.printAll();
        System.out.print("出队4次：");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printAll();
        System.out.print("入队1次：");
        queue.enqueue("5");
        queue.printAll();
        System.out.println("==========循环队列end==========\n");
    }

    //排序
    private static void sorts() {
        System.out.println("==========排序算法start==========");
        int[] items = {5, 7, 1, 8, 2, 5};
//        Sorts.bubbleSort(items, 6);
//        Sorts.insertionSort(items, 6);
//        Sorts.selectionSort(items, 6);
//        MergeSort.mergeSort(items, 6);
        QuickSort.quickSort(items, 6);
        for (int item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("==========排序算法end==========\n");
    }

    //O(n)时间复杂度内求无序数组中第K大元素
    private static void findRankKEle() {
        System.out.println("==========算法例子start==========");
        int[] a = {4, 2, 5, 12, 3};
        System.out.print("原数组：");
        for (int item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
        int value = AlgoExample.findRankKEle(a, 3);
        System.out.println("数组第3大元素是：" + value);
        int value1 = AlgoExample.findRankKEle(a, 1);
        System.out.println("数组第1大元素是：" + value1);
        System.out.println("==========算法例子end==========\n");
    }

    //计数排序
    private static void countingSort() {
        System.out.println("==========计数排序start==========");
        int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
        System.out.print("原数组：");
        for (int item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
        CountingSort.countingSort(a, 8);
        System.out.print("排序后：");
        for (int item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("==========计数排序end==========\n");
    }
}
