package com.swust.zj.leetcode.byteDance.arrayAndSort;

public class No_0042 {

    public int trap(int[] height) {
        int leftMaxHeight = 0;
        int[] leftMaxHeightArray = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            leftMaxHeightArray[i] = leftMaxHeight;
            if (height[i] > leftMaxHeight) {
                leftMaxHeight = height[i];
            }
        }
        int rightMaxHeight = 0;
        int[] rightMaxHeightArray = new int[height.length];
        for (int i = height.length - 1; i >= 0; i--) {
            rightMaxHeightArray[i] = rightMaxHeight;
            if (height[i] > rightMaxHeight) {
                rightMaxHeight = height[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int waterHeight = Math.min(leftMaxHeightArray[i], rightMaxHeightArray[i]) - height[i];
            sum += waterHeight >= 0 ? waterHeight : 0;
        }
        return sum;
    }

}
