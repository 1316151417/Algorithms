package com.swust.zj.sort;
/**
* @author 周杰
* @time 2017年8月27日 下午2:40:16
*/
/*
 * 选择排序
 * 比较次数：(n-1)+(n-2)+...+2+1 = n*(n-1)/2
 * 交换次数：n-1
 * 特点：
 * 数据交换次数少
 */
public class SelectionSort {
	public static void sort(Comparable[] data) {
		// TODO Auto-generated method stub
		for(int i=0;i<data.length-1;i++) {
			int minIndex = i;
			for(int j=i+1;j<data.length;j++) {
				if(Sort.less(data[j], data[minIndex])) {
					minIndex = j;
				}
			}
			Sort.exch(data, i, minIndex);
		}
	}
}
