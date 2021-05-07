package com.swust.zj.sort;

public class HeapSort {

    private void maxHeapify(int[] nums, int size, int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = leftIndex + 1;
        int largestIndex = index;
        if (leftIndex < size && nums[leftIndex] > nums[largestIndex]) {
            largestIndex = leftIndex;
        }
        if (rightIndex < size && nums[rightIndex] > nums[largestIndex]) {
            largestIndex = rightIndex;
        }
        if (largestIndex != index) {
            int temp = nums[index];
            nums[index] = nums[largestIndex];
            nums[largestIndex] = temp;
            maxHeapify(nums, size, largestIndex);
        }
    }

    private void buildMaxHeap(int[] nums, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, size, i);
        }
    }

    public void sort(int[] nums) {
        buildMaxHeap(nums, nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            maxHeapify(nums, i, 0);
        }
    }

}
