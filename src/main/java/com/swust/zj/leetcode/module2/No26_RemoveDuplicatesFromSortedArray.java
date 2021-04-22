package com.swust.zj.leetcode.module2;

public class No26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }
        int writePreIndex = 0, readIndex = 1, length = 1;
        while (readIndex < nums.length) {
            if (nums[readIndex] != nums[writePreIndex]) {
                nums[writePreIndex + 1] = nums[readIndex];
                writePreIndex++;
                length++;
            }
            readIndex++;
        }
        while (writePreIndex + 1 < nums.length) {
            nums[writePreIndex + 1] = 0;
            writePreIndex++;
        }
        return length;
    }

}
