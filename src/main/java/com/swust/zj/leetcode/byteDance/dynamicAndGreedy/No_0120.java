package com.swust.zj.leetcode.byteDance.dynamicAndGreedy;

import java.util.ArrayList;
import java.util.List;

public class No_0120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> idp = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                boolean contanisLeftParent = i - 1 >= 0 && i - 1 < dp.size()
                        && j - 1 >= 0 && j - 1 < dp.get(i - 1).size();
                boolean containsRightParent = i - 1 >= 0 && i - 1 < dp.size()
                        && j >= 0 && j < dp.get(i - 1).size();
                if (!contanisLeftParent && !containsRightParent) {
                    idp.add(triangle.get(i).get(j));
                } else if (contanisLeftParent && containsRightParent) {
                    idp.add(Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + triangle.get(i).get(j));
                } else if (contanisLeftParent) {
                    idp.add(dp.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                } else {
                    idp.add(dp.get(i - 1).get(j) + triangle.get(i).get(j));
                }
            }
            dp.add(idp);
        }
        int min = dp.get(dp.size() - 1).get(0);
        for (Integer total : dp.get(dp.size() - 1)) {
            min = Math.min(min, total);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);l.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);l2.add(4);l.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);l3.add(5);l3.add(7);l.add(l3);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);l4.add(1);l4.add(8);l4.add(3);l.add(l4);
        System.out.println(new No_0120().minimumTotal(l));
    }

}
