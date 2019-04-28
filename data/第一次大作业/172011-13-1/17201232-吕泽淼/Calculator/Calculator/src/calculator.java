import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class calculator {
	



		//枚举
	public enum operatorEnum{
			PLUS(0, '+'), MINUS(0, '-'), MULTIPLY(1, '*'), DIVIDE(1, '/'),  LEFT_BRACKET(2, '('), RIGHT_BRACKET(2, ')');//枚举操作符
			
			public Integer first;		//优先级     包装类int
			public Character opera;     	//操作符			包装类 char
				
			private operatorEnum(int first,char opera){
				this.first = first;
				this.opera = opera;
			}
				
			public String toString(){
				return String.valueOf(opera);
			}
					
		}
			
		//判断字符是否为操作符
	private operatorEnum isOperator(char c){
			for(operatorEnum p : operatorEnum.values()){
				if(c == p.opera){
					return p;
				}
			}
			return null;
		}
			
		//将计算式转换为后缀表达式
	public String toBack(String s1){
			//存放算数字符的数组
			char[] c = s1.trim().toCharArray();
			 LinkedList<operatorEnum> stack = new LinkedList<operatorEnum>();
			 StringBuilder sb = new StringBuilder();
			 
			 operatorEnum opera = null;
			 
			 for(int i = 0; i < c.length; i++){
				 //遍历每个字符，检查是否为操作符
				 if((opera = isOperator(c[i])) == null){
					 sb.append(c[i]);
				 }
				 //持续弹出栈顶元素直到左括号，但不输出
				 else if(opera.equals(operatorEnum.RIGHT_BRACKET)){
					 //如果不是左括号，持续弹出并输出
					 while(!stack.peek().equals(operatorEnum.LEFT_BRACKET)){
						 sb.append(stack.pop());
					 }
					 stack.pop();
				 }
				 else{
					 //弹出并输出所有高优先级或者同等优先级，直到遇到低优先级或者左括号为止
					 while(stack.size() > 0 && stack.peek().first >= opera.first && !stack.peek().equals(operatorEnum.LEFT_BRACKET)){
						 sb.append(stack.pop());
					 }
					 //入栈
					 stack.push(opera);
				 }
			 }
			 //弹出栈中剩下的所有操作符
			 while(stack.size() > 0){
				 sb.append(stack.pop());
			 }
			 return sb.toString();
		}
			
		//计算后缀表达式
	public double compute(String toback){
			char[] c = toback.toCharArray();
			LinkedList<Double> stack = new LinkedList<Double>();	//类型泛化
			operatorEnum opera = null;
			for(int i = 0; i < c.length; i++){
				//判断是否为操作符，如果是则入栈
				if((opera = isOperator(c[i])) == null){
					stack.push(Double.parseDouble(String.valueOf(c[i])));
				}
				else{
					//如果不是操作符，则进行计算
					double m = stack.pop();
					double n = stack.pop();
					switch(opera){
						
					case PLUS:
						stack.push(n + m);//对加法运算
						break;
					case MINUS:
						stack.push(n - m);//对减法运算
						break;
					case MULTIPLY:
						stack.push(n * m);//对乘法运算
						break;
					case DIVIDE:
						stack.push(n / m);//对除法运算
						break;
							
					default:
						break;
					}
				}
			}
			//返回弹出栈顶
			return stack.pop();
		}


}

