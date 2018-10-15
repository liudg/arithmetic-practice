package com.liudong.dataStruct;

/**
 * 循环队列
 */

public class CircularQueue {
    private String[] items;
    private int n;      //队列总大小
    private int size = 0;   //当前队列大小
    private int head = 0;   //队头
    private int tail = 0;   //队尾

    public CircularQueue(int n) {
        this.items = new String[n];
        this.n = n;
    }

    //入队
    public boolean enqueue(String item) {
        //判断队满
        if (size == n) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        size++;
        return true;
    }

    //出队
    public String dequeue() {
        //判断队空
        if (size == 0) return null;
        String ret = items[head];
        head = (head + 1) % n;
        size--;
        return ret;
    }

    public void printAll() {
        if(size == 0) return;
        for (int i = 0; i < size; i++) {
            int pos = (i + head) % n;
            System.out.print(items[pos] + " ");
        }
        System.out.println();
    }
}
