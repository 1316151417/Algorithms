package com.swust.zj.util;
/**
* @author 周杰
* @time 2017年8月27日 下午4:46:25
*/
public class ArrayUtil {
	public static Integer[] generateIntegerArray(int size) {
		Integer[] integers = new Integer[size];
		for(int i=0;i<size;i++) {
			integers[i] = (int) (Math.random()*Integer.MAX_VALUE);
		}
		return integers;
	}
	public static Integer[] copyIntegerArray(Integer[] data0) {
		Integer[] data = new Integer[data0.length];
		for(int i=0;i<data0.length;i++) {
			data[i] = data0[i];
		}
		return data;
	}
}
