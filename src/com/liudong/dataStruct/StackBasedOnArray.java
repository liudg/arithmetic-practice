package com.liudong.dataStruct;

/**
 * 基于数组实现的栈---顺序栈
 */

public class StackBasedOnArray {
    private String[] items;
    private int count;        //栈中元素个数
    private int n;            //栈的大小

    public StackBasedOnArray(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    //入栈
    public void push(String item) {
        //数组空间不够，自动扩容1倍
        if(n == count) {
            n = 2 * n;
            String[] tmp = new String[n];
            System.arraycopy(items, 0, tmp, 0, count);
            items = tmp;
            System.out.println("数组扩容了！");
        }
        items[count] = item;
        count++;
    }

    //出栈
    public String pop() {
        if(count == 0) return null;
        String tmp = items[count - 1];
        count--;
        return tmp;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
