package com.liudong.arithmetic;

/**
 * 冒泡、插入、选择排序（优先选择插入排序）
 */

public class Sorts {

    /**
     * 冒泡排序
     * <p>
     * 最好时间复杂度：O(n)
     * 最坏时间复杂度：O(n^2)
     * 平均时间复杂度：O(n^2)
     * <p>
     * 空间复杂度：O(1)
     */
    public static void bubbleSort(int[] a, int n) {
        if (n < 1) return;
        for (int i = 0; i < n - 1; i++) {
            //标志是否没有数据交换了，提前结束
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    /**
     * 插入排序
     * <p>
     * 最好时间复杂度：O(n)
     * 最坏时间复杂度：O(n^2)
     * 平均时间复杂度：O(n^2)
     * <p>
     * 空间复杂度：O(1)
     */
    public static void insertionSort(int[] a, int n) {
        if (n < 1) return;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     * <p>
     * 最好时间复杂度：O(n^2)
     * 最坏时间复杂度：O(n^2)
     * 平均时间复杂度：O(n^2)
     * <p>
     * 空间复杂度：O(1)
     */
    public static void selectionSort(int[] a, int n) {
        if (n < 1) return;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int minValue = a[i];
            for (int j = i + 1; j < n; j++) {
                if (a[j] < minValue) {
                    minValue = a[j];
                    minIndex = j;
                }
            }
            //交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    /**
     * 插入排序优化版---希尔排序
     */
    public static void shellSort(int[] a, int n) {
    }
}
