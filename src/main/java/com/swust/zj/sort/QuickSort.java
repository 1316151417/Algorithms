package com.swust.zj.sort;

public class QuickSort {

    public static void sort(Comparable[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(Comparable[] data, int low, int high) {
        if(low >= high) {
            return;
        }
        int index = getIndex(data, low, high);
        sort(data, low, index - 1);
        sort(data, index + 1, high);
    }

    private static int getIndex(Comparable[] data, int low, int high) {
        Comparable base = data[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && Sort.greaterAndEqual(data[j], base)) {
                j--;
            }
            data[i] = data[j];
            while (i < j && Sort.lessAndEqual(data[i], base)) {
                i++;
            }
            data[j] = data[i];
        }
        data[i] = base;
        return i;
    }
}
