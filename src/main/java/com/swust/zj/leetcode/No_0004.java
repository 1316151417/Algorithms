package com.swust.zj.leetcode;

public class No_0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, total = nums1.length + nums2.length;
        boolean even = total % 2 == 0;
        int start = even ? total / 2 - 1 : total / 2;
        int sum = 0;
        int count = 0;
        boolean isNum1;
        while (i < nums1.length || j < nums2.length) {
            if (j >= nums2.length || (i < nums1.length && nums1[i] < nums2[j])) {
                isNum1 = true;
            } else {
                isNum1 = false;
            }
            if (i + j == start || (even && i + j == start + 1)) {
                sum += isNum1 ? nums1[i] : nums2[j];
                count++;
            }
            if (isNum1) {
                i++;
            } else {
                j++;
            }
            if ((!even && count == 1) || (even && count == 2)) {
                break;
            }
        }
        return ((double) sum) / count;
    }

    public static void main(String[] args) {
        System.out.println(new No_0004().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
