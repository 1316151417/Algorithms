package com.swust.zj.leetcode.byteDance.string;

import java.util.ArrayList;
import java.util.List;

public class No_0093 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ipList = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ipList);
        return ipList;
    }

    private boolean valid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) {
            return false;
        }
        int segmentValue = Integer.valueOf(segment);
        if (segmentValue >= 0 && segmentValue <= 255) {
            return true;
        }
        return false;
    }

    private void backtrack(String s, int index, List<String> segmentList, List<String> out) {
        if (segmentList.size() == 4) {
            if (index == s.length()) {
                out.add(segmentListToIp(segmentList));
            }
            return;
        }
        for (int length = 1; length <= 3; length++) {
            if (index + length > s.length()) {
                continue;
            }
            String segment = s.substring(index, index + length);
            if (valid(segment)) {
                segmentList.add(segment);
                backtrack(s, index + length, segmentList, out);
                segmentList.remove(segmentList.size() - 1);
            }
        }
    }

    private String segmentListToIp(List<String> segmentList) {
        StringBuilder ipBuilder = new StringBuilder();
        for (int i = 0; i < segmentList.size(); i++) {
            if (i != 0) {
                ipBuilder.append(".");
            }
            ipBuilder.append(segmentList.get(i));
        }
        return ipBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No_0093().restoreIpAddresses("010010"));
    }
}
