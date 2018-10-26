package com.liudong.arithmetic;

/**
 * 记数排序---稳定排序
 * 时间复杂度：O(n)
 * 用途：适合数据范围小的处理
 */

public class CountingSort {

    //假设数组中存储的都是非负整数
    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;

        //查找数组中数据的范围
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > max) max = a[i];
        }

        //申请一个计数数组，大小为[0, max]
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            c[i] = 0;
        }

        //计算每个元素的个数，放入c中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }

        //申请一个临时数组r，存放排序后的结果
        int[] r = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        //将结果拷贝给a数组
        System.arraycopy(r, 0, a, 0, n);
    }
}
