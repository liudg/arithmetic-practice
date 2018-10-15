package com.liudong.dataStruct;

/**
 * 1）基于数组实现的队列
 * 2）参考：https://github.com/wangzheng0822/algo/blob/master/java/09_queue/ArrayQueue.java
 */

public class ArrayQueue {
    private String[] items;
    private int n;        //数组大小
    private int head = 0;     //对头下标
    private int tail = 0;     //队尾下标

    public ArrayQueue(int n) {
        this.n = n;
        this.items = new String[n];
    }

    //入队
    public boolean push(String value) {
        //队列满
        if(tail == n) {
            if(head == 0) return false;
            //数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = value;
        tail++;
        return true;
    }

    //出队
    public String pop() {
        if (head == tail) return null;
        String ret = items[head];
        head++;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
