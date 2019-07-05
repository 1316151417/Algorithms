package com.swust.zj.sort;
/**
* @author 周杰
* @time 2017年8月27日 下午2:52:56
*/
public class Sort {
	public static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}

	public static void exch(Comparable[] data, int i, int j) {
		Comparable temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		//help GC
		temp = null;
	}

	public static boolean isSorted(Comparable[] data) {
		for (int i = 1; i < data.length; i++) {
			if (less(data[i], data[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void show(Comparable[] data) {
		for (int i = 0; i < data.length; i++) {
			if (i > 0) {
				System.out.print(" ");
			}
			System.out.print(data[i]);
		}
		System.out.println();
	}
}
