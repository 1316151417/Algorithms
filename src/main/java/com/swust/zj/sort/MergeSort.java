package com.swust.zj.sort;

public class MergeSort {

    public static void sort(Comparable[] data) {
        sort(data, 0, data.length - 1, new Comparable[data.length]);
    }

    private static void sort(Comparable[] data, int low, int high, Comparable[] aux) {
        if(low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(data, low, mid, aux);
        sort(data, mid + 1, high, aux);
        merge(data, low, mid, high, aux);
    }

    private static void merge(Comparable[] data, int low, int mid, int high, Comparable[] aux) {
        int i = low;
        int j = mid + 1;
        for (int k = low; i <= mid || j <= high; ) {
            if (i > mid) {
                aux[k++] = data[j++];
            } else if (j > high) {
                aux[k++] = data[i++];
            } else if (Sort.less(data[i], data[j])) {
                aux[k++] = data[i++];
            } else {
                aux[k++] = data[j++];
            }
        }
        for (int k = low; k <= high; k++) {
            data[k] = aux[k];
        }
    }
}
