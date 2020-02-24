package com.swust.zj.leetcode.byteDance.arrayAndSort;


public class No_0215 {

    public int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums, nums.length);
        for (int i = 1; i <= k; i++) {
            int currentLength = nums.length - i;
            int temp = nums[0];
            nums[0] = nums[currentLength];
            nums[currentLength] = temp;
            heapify(nums, currentLength, 0);
        }
        return nums[nums.length - k];
    }

    public void buildMaxHeap(int[] nums, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(nums, length, i);
        }
    }

    public void heapify(int[] nums, int length, int i) {
        int left = i * 2 + 1, right = left + 1, maxIndex = i;
        if (left < length && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        if (right < length && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        if(maxIndex != i) {
            int temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
            heapify(nums, length, maxIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println(new No_0215().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
