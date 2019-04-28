package FourOperation;

import java.util.ArrayList;

/**
 * 该类进行对表达式的数值与操作符分离
 * 提供计算入口
 */
public class Expression {
	//初始定义那些可能出现的运算符
	private char[] ch = {'(',')','+','-','*','/'};
	/**
	 * 无参构造函数	
	 */
	Expression(){}	
	
	/**
	 * 将表达式的数值与操作符分离
	 * @param expression
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> dealWithExpression(String expression){
		
		int length = expression.length();//表达式长度
		
		ArrayList<String> exp = new ArrayList<>();//将数值和运算符分开后存放进列表
		char[] num = new char[8];//临时存放数值
		int flag = 0;//数值标识位
		int j = 0;//数字长度
		for(int i = 0;i < length; i++) {
			
			if(isOptr(expression.charAt(i))) {//如果当前位置是运算符
				if(flag == 1) {//之前有数值
					exp.add(String.valueOf(num));//数值添加进列表
					for(int k = 0;k < 8; k++) {//重新给数值数组赋初值
						num[k] = 0;
					}
				}
				exp.add(String.valueOf(expression.charAt(i)));//操作符添加进列表
				flag = 0;//数值标记清零
				j = 0;//数值计数清零
			}
			else {
				num[j] = expression.charAt(i);//数值数组填值
				j++;//数值个数计数
				flag = 1;//打上数值标记
			}
		}
		if(flag == 1)//表达式最后一个是数字的情况
			exp.add(String.valueOf(num));//数值添加进列表
			
		return exp;//返回分好类的列表
	}
	/**
	 * 判断当前字符是不是初始定义的运算符中的一个
	 * @param str
	 * @return boolean
	 */
	private boolean isOptr(char str) {
		boolean mark = false;//默认不是运算符
		for(int i = 0;i < 6; i++)
		{
			if(str == ch[i]){
				mark = true;
				break;
			}
		}
		return mark;
	}
	/**
	 * 提供计算结果的入口
	 * @param expression
	 * @return double
	 */
	public double getResult(String expression) {//获取算式结果	
		//申请一个列表用来存储分好类的表达式
		ArrayList<String> exp = new ArrayList<>();
		exp = dealWithExpression(expression);
		//申请一个逆波兰类的对象
		ReversePolishType express = new ReversePolishType();
		//调用逆波兰的求值函数，并返回结果值
		return express.calculate(exp);
	}
	
}
