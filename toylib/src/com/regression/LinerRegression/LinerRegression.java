package com.regression.LinerRegression;
import java.util.Arrays;

import com.common.optimization.Optimization;
import com.common.util.pretreatutil.PreTreatUtil;
import com.regression.Regression;
import  com.common.data.Data;;
/**
 * 接受输入样本{ x(i) },得到最优参数向量theta 
 * @author ooon
 *
 */
public class LinerRegression extends Regression{
	/**
	 * 参数向量
	 */
	double[] theta ;
	/**
	 * 梯度下降求解法
	 * @param a  学习速率
 	 * @param iter 迭代次数
	 * @return 
	 */
	public void GraidentDescent(float a, int iter){
		//加载数据
		try {PreTreatUtil.loadData("data/ex1data2.txt");
		} catch (Exception e) {e.printStackTrace();}
		theta = Optimization.GDA(Data.X,Data.Y,a,Data.m,iter);
	}
	/**
	 * 给出输入，求输出
	 * @param input
	 * @return
	 */
	public double forecast(double input[]){
		PreTreatUtil.scaling(input);
		double value = theta[0];
		for(int i = 1 ; i < theta.length ; i ++){
			value += input[i-1] * theta[i];
		}
		return value;
	}
	public static void main(String[] args) {
		LinerRegression lr = new LinerRegression();
		lr.GraidentDescent(0.1f, 2000);
		double[] input = { 4000d , 5d};
		System.out.println(lr.forecast(input));
	}
}
