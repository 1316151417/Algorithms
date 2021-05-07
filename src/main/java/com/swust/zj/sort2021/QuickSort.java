package com.swust.zj.sort2021;

public class QuickSort {

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int from, int to) {
        if (from >= to) {
            return;
        }
        int baseIndex = getPartitionIndex(nums, from, to);
        sort(nums, from, baseIndex - 1);
        sort(nums, baseIndex + 1, to);
    }

    private int getPartitionIndex(int[] nums, int from, int to) {
        int baseIndex = from;
        int partitionIndex = baseIndex;
        for (int cursor = baseIndex + 1; cursor <= to; cursor++) {
            if (nums[cursor] <= nums[baseIndex]) {
                partitionIndex++;
                int temp = nums[partitionIndex];
                nums[partitionIndex] = nums[cursor];
                nums[cursor] = temp;
            }
        }
        int temp = nums[partitionIndex];
        nums[partitionIndex] = nums[baseIndex];
        nums[baseIndex] = temp;
        return partitionIndex;
    }

}
