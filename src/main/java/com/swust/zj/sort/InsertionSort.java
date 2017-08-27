package com.swust.zj.sort;
/**
* @author 周杰
* @time 2017年8月27日 下午3:19:42
*/
/*
 * 插入排序
 * 比较次数：平均（n*(n-1)/4）、最差（n*(n-1)/2）、最好（n-1）
 * 交换次数：平均（n*(n-1)/4）、最差（n*(n-1)/2）、最好（0）
 * 特点：
 * 对已有序或接近有序数组排序效率高
 */
public class InsertionSort {
	public static void sort(Comparable[] data) {
		for(int i=1;i<data.length;i++) {
			for(int j=i;j>=1 && Sort.less(data[j], data[j-1]);j--) {
				Sort.exch(data, j, j-1);
			}
		}
	}
}
