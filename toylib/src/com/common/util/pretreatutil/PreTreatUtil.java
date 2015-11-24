package com.common.util.pretreatutil;

import java.util.List;

import com.common.data.Data;
import com.common.util.fileutil.FileUtil;

public class PreTreatUtil {
	/**
	 * 具体的预处理方法
	 * @throws Exception 
	 */
	public static void loadData(String path) throws Exception{
		List<String> lines = FileUtil.getLines(path);
		if (lines.size() == 0 )//读取异常
		{ 
			System.err.println("读取 "+path+" 出错！");
			System.exit(0);
		}
		//feature num
		Data.featureNum = lines.get(0).split(",").length;
		Data.m = lines.size();
		Data.X = new double[Data.m][Data.featureNum];
		Data.initX = new double[Data.m][Data.featureNum];
		Data.Y = new double[Data.m];
		Data.MAX = new double[Data.featureNum];
		Data.MIN = new double[Data.featureNum];

		Data.MAX[0] = 1d ;
		Data.MIN[0] = 1d ;
		for(int i = 1 ; i < Data.MIN.length ; i ++)
		{
			Data.MIN[i] = Double.MAX_VALUE;
		}
		//初始读取得到最大最小与初始值
		for(int i = 0 ; i < lines.size() ;i ++)
		{
			//x0都设置为1
			Data.initX[i][0] = 1d;
			String line = lines.get(i);
			String[] elements = line.split(",");
			for(int j = 0 ; j < elements.length-1 ; j ++)
			{
				Data.initX[i][j+1] = Double.parseDouble(elements[j]);
				Data.MAX[j+1] = Data.initX[i][j+1] > Data.MAX[j+1] ?  Data.initX[i][j+1] : Data.MAX[j+1];
				Data.MIN[j+1] = Data.initX[i][j+1] < Data.MIN[j+1] ?  Data.initX[i][j+1] : Data.MIN[j+1];
			}
			Data.Y[i] = Double.parseDouble(elements[elements.length-1]);
		}
		//feature scaling 
		for(int row = 0 ; row < Data.initX.length ;row ++)
		{
			Data.X[row][0] = 1d;
			for(int col = 1 ; col < Data.initX[0].length ; col ++)
			{
				Data.X[row][col] = (Data.initX[row][col] - Data.MIN[col])/(Data.MAX[col] -Data.MIN[col]);
			}
		}	
	}
	public static void scaling(double[] input){
		for(int i = 1 ; i < Data.MAX.length ; i ++){
			input[i-1] = (input[i-1] - Data.MIN[i])/(Data.MAX[i] -Data.MIN[i]);
		}
	}
//	public static void main(String[] args) throws Exception {
//		preTreat("data/ex1data2.txt");
//		System.out.println(Data.printData());
//	}
}
