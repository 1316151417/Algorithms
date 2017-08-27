package com.swust.zj.test;
/**
* @author 周杰
* @time 2017年8月27日 下午4:21:10
*/

import org.junit.Test;

import com.swust.zj.sort.InsertionSort;
import com.swust.zj.sort.SelectionSort;
import com.swust.zj.sort.ShellSort;
import com.swust.zj.util.ArrayUtil;
import com.swust.zj.util.TimerUtil;

public class SortTest {
	@Test
	public void easySortTest() {
		Integer[] data0 = ArrayUtil.generateIntegerArray(100000);
		Integer[] data1 = ArrayUtil.copyIntegerArray(data0);
		Integer[] data2 = ArrayUtil.copyIntegerArray(data0);
		//Selection
		TimerUtil.start();
		SelectionSort.sort(data0);
		System.out.println("Selection sort spent time : " + TimerUtil.end() + "ms");
		//Insertion
		TimerUtil.start();
		InsertionSort.sort(data1);
		System.out.println("Insertion sort spent time : " + TimerUtil.end() + "ms");
		//Shell
		TimerUtil.start();
		ShellSort.Sort(data2);
		System.out.println("Shell sort spent time : " + TimerUtil.end() + "ms");
	}
}
