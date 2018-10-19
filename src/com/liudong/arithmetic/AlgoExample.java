package com.liudong.arithmetic;

/**
 * 算法题目
 * 1）O(n)时间复杂度内求无序数组中第K大元素
 */

public class AlgoExample {

    //O(n)时间复杂度内求无序数组中第K大元素
    public static int findRankKEle(int[] a, int k) {
        int p = 0;
        int r = a.length - 1;
        int q = partition(a, p, r);
        while (q + 1 != k) {
            if (k > q + 1) {
                q = partition(a, q + 1, r);
            } else {
                q = partition(a, p, q - 1);
            }
        }
        return a[q];
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
        return i;
    }
}
