package com.liudong.arithmetic;

import com.liudong.dataStruct.SinglyLinkedList;

/**
 * 算法：
 * 1）单链表反转
 * 2）链表中环的检测
 * 3）两个有序的链表合并
 * 4）删除链表倒数第n个节点
 * 5）求链表的中间节点
 */

public class LinkedListAlgo {

    // 单链表反转
    public static SinglyLinkedList.Node reverse(SinglyLinkedList.Node list) {
        SinglyLinkedList.Node headNode = null;
        SinglyLinkedList.Node prevNode = null;
        SinglyLinkedList.Node curNode = list;
        while (curNode != null) {
            SinglyLinkedList.Node nextNode = curNode.next;
            if (nextNode == null) {
                headNode = curNode;
            }
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return headNode;
    }

    // 链表中环检测
    public static boolean checkCircle(SinglyLinkedList.Node list) {
        if (list == null) return false;

        // 一快一慢两个指针，能相遇说明有环
        SinglyLinkedList.Node fast = list.next;
        SinglyLinkedList.Node slow = list;

        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    // 两个有序链表的合并
    public static SinglyLinkedList.Node mergeLinkedList(SinglyLinkedList.Node la, SinglyLinkedList.Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;

        SinglyLinkedList.Node head;
        SinglyLinkedList.Node p = la;
        SinglyLinkedList.Node q = lb;
        if (p.getData() > q.getData()) {
            head = q;
            q = q.next;
        } else {
            head = p;
            p = p.next;
        }
        SinglyLinkedList.Node r = head;
        while (p != null && q != null) {
            if (p.getData() < q.getData()) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }
        return head;
    }

    // 删除链表倒数第n个节点
    public static SinglyLinkedList.Node deleteNode(SinglyLinkedList.Node head, int n) {
        SinglyLinkedList.Node fast = head;
        int i = 1;
        while (fast != null && i < n) {
            fast = fast.next;
            i++;
        }
        if (fast == null) return head;
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }
        return head;
    }
}
