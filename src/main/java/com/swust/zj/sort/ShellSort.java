package com.swust.zj.sort;
/**
* @author 周杰
* @time 2017年8月27日 下午4:09:14
*/
/*
 * 希尔排序
 * 比较次数：无解
 * 交换次数：无解
 * 特点：
 * 代码简单、效率高
 */
public class ShellSort {
	public static void Sort(Comparable[] data) {
		int h = 1;
		while(h < data.length/3) {
			h = 3 * h + 1;
		}
		while(h >= 1) {
			for(int i=h;i<data.length;i++) {
				for(int j=i;j>=h && Sort.less(data[j], data[j-h]);j-=h) {
					Sort.exch(data, j, j-h);
				}
			}
			h /= 3;
		}
	}
}
