package com.swust.zj.sort2021;

public class MergeSort {

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private void sort(int[] nums, int left, int right, int[] aux) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(nums, left, mid, aux);
        sort(nums, mid + 1, right, aux);
        merge(nums, left, mid, right, aux);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] aux) {
        int auxIndex = left;
        int i = left, j = mid + 1;
        while (i <= mid || j <= right) {
            if (i > mid) {
                aux[auxIndex++] = nums[j++];
            } else if (j > right) {
                aux[auxIndex++] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                aux[auxIndex++] = nums[i++];
            } else {
                aux[auxIndex++] = nums[j++];
            }
        }
        for (int k = left; k <= right; k++) {
            nums[k] = aux[k];
        }
    }

}
