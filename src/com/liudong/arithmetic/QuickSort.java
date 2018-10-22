package com.liudong.arithmetic;

/**
 * 快速排序---不稳定算法
 * 时间复杂度：O(nlogn)，极端情况下会变成：O(n^2)
 * 空间复杂度：O(1)
 */

public class QuickSort {

    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        //递归终止条件
        if (p >= r) return;
        //计算分区点（合理选择分区点能带来很大优化，理想情况是被分开的两个区间数据量差不多）
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }
}
