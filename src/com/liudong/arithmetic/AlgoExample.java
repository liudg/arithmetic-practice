package com.liudong.arithmetic;

/**
 * 算法题目
 * 1）O(n)时间复杂度内求无序数组中第K大元素
 * 2）二分查找变形
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

    //查找第一个值等于给定值的元素
    public static int findFirstEqValue(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2); //不用(low + high) / 2，是为了避免low + high值溢出
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素
    public static int findLastEqValue(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2); //不用(low + high) / 2，是为了避免low + high值溢出
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == a.length - 1 || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的元素
    public static int findFirstGtValue(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    public static int findLastLtValue(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if ((mid == a.length - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
