package com.swust.zj.leetcode.byteDance.string;

import java.util.ArrayList;
import java.util.List;

public class No_0071 {

    public String simplifyPath(String path) {
        List<String> reallyDirList = new ArrayList<>();

        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (!dir.trim().isEmpty()) {
                if (dir.equals(".")) {
                    continue;
                } else if (dir.equals("..")) {
                    if (reallyDirList.isEmpty()) {
                        continue;
                    }
                    reallyDirList.remove(reallyDirList.size() - 1);
                } else {
                    reallyDirList.add(dir);
                }
            }
        }
        if (reallyDirList.isEmpty()) {
            return "/";
        }
        StringBuilder reallyPathBuilder = new StringBuilder();
        for (int i = 0; i < reallyDirList.size(); i++) {
            reallyPathBuilder.append("/").append(reallyDirList.get(i));
        }
        return reallyPathBuilder.toString();
    }

}
