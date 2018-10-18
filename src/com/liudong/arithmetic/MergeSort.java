package com.liudong.arithmetic;

/**
 * 归并排序---稳定算法
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */

public class MergeSort {

    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    //递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
        //递归终止条件
        if (p >= r) return;
        //取中点
        int q = (p + r) / 2;
        //分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    //合并数组
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];  //申请一个跟a[p...r]一样大的临时数组
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        //判断哪个子数组有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        //搬移数据
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }
    }
}
