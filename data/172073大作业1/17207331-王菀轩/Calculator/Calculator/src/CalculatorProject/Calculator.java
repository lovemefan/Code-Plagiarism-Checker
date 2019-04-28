package CalculatorProject;

import java.util.Stack;
import java.io.*;

public class Calculator {

	public static void main(String[] args) throws Exception {
		File resultFile = new File("src\\CalculatorProject\\Result");
		
		//输出操作，将运算结果和表达式判断结果输出到Result文件中
		try(PrintWriter output = new PrintWriter(resultFile);)
		{
			for(int i=1 ; i<=Expression.amountExpression() ; i++)
			{
				Expression expression = new Expression(i);
				
				if(expression.rightExpression)	//表达式正确输出结果，表达式错误输出错误内容
					output.println(expression.expression + "=" + operate(expression.expression));
				else
				{
					output.println("ERROR");
					output.println(expression.question);
				}
			}
		}
	}
	
	//对表达式进行处理与计算
	public static float operate(String expression)
	{
		Stack<Float> operand = new Stack<Float>();		//储存操作数的栈
		Stack<Character> operator = new Stack<Character>();	//储存操作符的栈
		
		String temp = "";	//在操作符前后加空格的临时表达式
		
		for (int i = 0; i < expression.length(); i++)
		{
			if(expression.substring(i, i+1).matches("[+-/*\\(\\)]"))
				temp += " " + expression.charAt(i) + " ";		//操作符前后加空格
			else
				temp += expression.charAt(i);
		}
		
		String[] strArry = temp.split(" ");		//讲操作符与操作数都拆开放置
		
		for(String e:strArry)
		{
			if(e.length() == 0)		//除去表达式原有的空格
				continue;
			if(e.matches("[0-9].*"))
				operand.push(Float.parseFloat(e));
			else if(e.matches("[+-]"))
			{
				//栈非空并且栈顶元素为+-*/号进行计算
				while(!operator.empty() && operator.peek().toString().matches("[+-/*]"))	
					compute(operand, operator);
				operator.push(e.charAt(0));
			}
			else if(e.matches("[/*]"))
			{
				//栈非空并且栈顶元素为*/号
				while(!operator.empty() && operator.peek().toString().matches("[/*]"))
					compute(operand, operator);
				operator.push(e.charAt(0));
			}
			//对括号进行处理
			else if(e.matches("\\("))
				operator.push(e.charAt(0));
			else if(e.matches("\\)")) 
			{
				while(!operator.peek().equals('('))
					compute(operand, operator);
				operator.pop();
			}
		}
		//当运算符栈还有操作符继续进行运算
		while(!operator.empty())
			compute(operand, operator);
		
		return operand.pop();
	}
	
	//对加减乘除进行运算并将计算出来的数推入运算数栈
	private static void compute(Stack<Float> operand, Stack<Character> operator)
	{
		char opt = operator.pop();
		float data1 = operand.pop();
		float data2 = operand.pop();
		
		switch(opt)
		{
		case '+':	//加法运算
			operand.push(data2 + data1);
			break;
		case '-':	//减法运算
			operand.push(data2 - data1);
			break;
		case '*':	//乘法运算
			operand.push(data2 * data1);
			break;
		case '/':	//除法运算
			operand.push(data2 / data1);
			break;
		}
	}

}
