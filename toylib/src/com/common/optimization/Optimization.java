package com.common.optimization;

public class Optimization {
	/**
	 * Graident Descent 给定训练数据，返回参数向量
	 * @param X 
	 * @param Y 
	 * @param iter  迭代慈湖
	 * @param a 学习速率
	 * @param m total example
	 * @return 参数向量
	 */
	public static double[] GDA(double X[][],double Y[],float a,int m,int iter){
		
		double[] temp_theta = new double[X[0].length];
		double[] res__theta = new double[X[0].length];
		int iteration =0 ;
		while(iteration++ < iter ){
			//迭代更新theta
			for(int i = 0 ; i < temp_theta.length ; i ++)
			{
				double tempsum = 0;
				for(int row = 0; row < X.length ; row ++)
				{
					double y_ = 0;
					for(int col = 0 ; col < X[0].length ; col ++)
					{
						y_ += X[row][col]* res__theta[col];
					}
					tempsum += (y_ - Y[row])*X[row][i];
				}
				temp_theta[i] -= a / m * tempsum;
			}
			res__theta = temp_theta;
			//每次整体更新完theta，计算下午茶
			double loss = 0d;
			for(int row = 0; row < X.length ; row ++)
			{
				double y_ = 0;
				for(int col = 0 ; col < X[0].length ; col ++)
				{
					y_ += X[row][col]* res__theta[col];
				}
				loss += Math.pow((y_ - Y[row]),2);
			}
			loss /= m;
			System.out.println(loss);
		}
		return res__theta;
	}
}
