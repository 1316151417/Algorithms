package com.swust.zj.leetcode.byteDance.string;

public class No_0043 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String addResult = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder multiplyResult = new StringBuilder();
            for (int j = 0; j < (num2.length() - i - 1); j++) {
                multiplyResult.append("0");
            }
            int carry = 0;
            int indexNum2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int indexNum1 = j >= 0 ? num1.charAt(j) - '0' : 0;
                int indexMultiplyResult = indexNum1 * indexNum2 + carry;
                carry = indexMultiplyResult / 10;
                multiplyResult.append(indexMultiplyResult % 10);
            }
            addResult = add(addResult, multiplyResult.reverse().toString());
        }
        return addResult;
    }

    private String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        for (int num1Index = num1.length() - 1, num2Index = num2.length() - 1, carry = 0;
             num1Index >= 0 || num2Index >= 0 || carry != 0;
             num1Index--, num2Index--) {
            int indexNum1 = num1Index >= 0 ? (num1.charAt(num1Index) - '0') : 0;
            int indexNum2 = num2Index >= 0 ? (num2.charAt(num2Index) - '0') : 0;
            int temp = indexNum1 + indexNum2 + carry;
            carry = temp / 10;
            result.append(temp % 10);
        }
        return result.reverse().toString();
    }

}
