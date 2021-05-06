package com.swust.zj.sort2021;

import java.util.function.Consumer;

public class SortTest {

    public static void main(String[] args) {
        SortTest.sort(new InsertionSort()::sort);
        SortTest.sort(new HeapSort()::sort);
        SortTest.sort(new MergeSort()::sort);
        SortTest.sort(new SelectionSort()::sort);
    }

    private static void sort(Consumer<int[]> sorter) {
        int[] nums = new int[]{6, 3, 7, 4, 7, 9, 4, 1};
        sorter.accept(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
