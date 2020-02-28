package com.swust.zj.leetcode.byteDance.expantion;

public class No_0393 {

    public boolean validUtf8(int[] data) {
        int length = 0;
        for (int i = 0; i < data.length; i++) {
            int[] bytes = intToBytes(data[i]);
            if (length == 0) {
                length = lengthOfUtf8Bytes(bytes);
                if (length < 1 || length > 4) {
                    return false;
                }
            } else if (length > 0) {
                if (bytes[0] != 1 || bytes[1] != 0) {
                    return false;
                }
            }
            length--;
        }
        return length == 0 ? true : false;
    }

    private int lengthOfUtf8Bytes(int[] bytes) {
        if (bytes[0] == 0) {
            return 1;
        }
        int count = 0;
        for (int b : bytes) {
            if (b == 0) {
                break;
            }
            count++;
        }
        return count == 1 ? -1 : count;
    }

    private int[] intToBytes(int data) {
        int[] bytes = new int[8];
        int bit = 0b10000000;
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (data & bit) > 0 ? 1 : 0;
            bit >>>= 1;
        }
        return bytes;
    }

    public static void main(String[] args) {
        System.out.println(new No_0393().validUtf8(new int[]{145}));
    }
}
