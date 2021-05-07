package com.swust.zj.sort;

public class ShellSort {

    public void sort(int[] nums) {
        int h = nums.length;
        while (h != 1) {
            h = h / 3 + 1;
            for (int i = h; i < nums.length; i++) {
                int current = nums[i];
                int j = i - h;
                while (j >= 0 && nums[j] > current) {
                    nums[j + h] = nums[j];
                    j = j - h;
                }
                nums[j + h] = current;
            }
        }
    }

}
