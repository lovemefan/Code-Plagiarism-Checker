package CalculatorProject;

import java.io.*;
import java.util.Stack;
import java.util.Scanner;

public class Expression {
	String expression = null;
	boolean rightExpression = true;
	String question = null;

	Expression(int point) throws Exception
	{
		int num = 0;
		
		File expressionFile = new File("src\\CalculatorProject\\AllExpression");
		
		try(Scanner input = new Scanner(expressionFile);)
		{
			while(input.hasNext() && (point != num))
			{
				this.expression = input.nextLine();
				num++;
			}
			judgeExpression();
		}
	}

	public static int amountExpression() throws Exception
	{
		int num = 0;
		
		File expressionFile = new File("src\\CalculatorProject\\AllExpression");
		
		try(Scanner input = new Scanner(expressionFile);)
		{
			while(input.hasNext())
			{
				input.nextLine();
				num++;
			}
		}
		return num;
	}
	
	//
	void judgeExpression()
	{
		Stack<Character> bracket = new Stack<Character>();
		
		//表达式为空
		if(this.expression.equals(""))
		{
			this.rightExpression = false;
			this.question = "#表达式为空";
			return;
		}
		//表达式中有空括号
		if(this.expression.matches(".*\\(\\).*"))
		{
			this.rightExpression = false;
			this.question = "#表达式中有空括号";
			return;
		}
		//表达式包含非法字符
		if(this.expression.matches(".*[!@#$%^&?<>,.;\\\\|{}\\[\\]=\":[a-z[A-Z]]].*"))
		{
			this.rightExpression = false;
			this.question = "#表达式包含非法字符";
			return;
		}
		//括号不匹配
		for(int i=0 ; i<this.expression.length() ; i++)
		{
			if(this.expression.charAt(i) == '(')
				bracket.push('(');
			if(this.expression.charAt(i) == ')')
			{
				if(!bracket.isEmpty())
					bracket.pop();
				else
				{
					this.rightExpression = false;
					this.question = "#括号不匹配";
					return;
				}
			}
		}
		if(!bracket.isEmpty())
		{
			this.rightExpression = false;
			this.question = "#括号不匹配";
			return;
		}
		
		//运算符连续
		if(this.expression.matches(".*[+-/*][+-/*].*"))
		{
			this.rightExpression = false;
			this.question = "#运算符连续";
			return;
		}
		//运算符前无运算数
		if(this.expression.substring(0, 1).matches("[+-/*]") || this.expression.matches(".*\\([+-/*].*"))
		{
			this.rightExpression = false;
			this.question = "#运算符前无运算数";
			return;
		}
		//运算符后无运算数
		if(this.expression.substring(this.expression.length()-1).matches("[+-/*]") || this.expression.matches(".*[+-/*]\\).*"))
		{
			this.rightExpression = false;
			this.question = "#运算符后无运算数";
			return;
		}
		//小括号前无运算符，括号非第一个字符
		if(this.expression.matches(".*[0-9]\\(.*"))
		{
			this.rightExpression = false;
			this.question = "#小括号前无运算符，括号非第一个字符";
			return;
		}
		//小括号后无运算符，括号非第一个字符
		if(this.expression.matches(".*\\)[0-9].*"))
		{
			this.rightExpression = false;
			this.question = "#小括号后无运算符，括号非第一个字符";
			return;
		}
	}
	
	//字符串中指定字符出现的次数
	int countStr(String str, char key) {
	    int count = 0;
	    for (int i = 0; i < str.length(); i++) {
	        if (str.charAt(i) == key)
	            count++;
	    }
	    return count;	//返回指定字符出现的次数
	}
}
