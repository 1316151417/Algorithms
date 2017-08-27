package com.swust.zj.util;
/**
* @author 周杰
* @time 2017年8月27日 下午4:44:22
*/
public class TimerUtil {
	private static long time;
	public static void start() {
		time = System.currentTimeMillis();
	}
	public static long end() {
		return System.currentTimeMillis()-time;
	}
}
