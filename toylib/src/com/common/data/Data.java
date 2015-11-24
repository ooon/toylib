package com.common.data;

import java.util.Arrays;

public class Data {
	/**
	 *  x & y
	 */
	public static double X[][];
	public static double Y[];
	/**
	 * inital x
	 */
	public static double initX[][];
	/**
	 * max & min
	 */
	public static double[] MAX ;
	public static double[] MIN ;
	/**
	 * total example(length)
	 */
	public static int m;
	/**
	 * featureNum;(width)
	 */
	public static int featureNum;
	
	public static String printData(){
		StringBuilder sb = new StringBuilder();
		sb.append("initX:").append("\t").append("X:").append("\n");
		for(int i = 0 ; i < X.length ; i ++){
			sb.append(Arrays.toString(initX[i])).append("\t").append(Arrays.toString(X[i])).append("\n");
		}
		
		sb.append("Y:").append("\n");
		sb.append(Arrays.toString(Y)).append("\n");
		return sb.toString();
	}
}
