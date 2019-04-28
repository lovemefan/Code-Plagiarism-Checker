package 大作业01;

import java.io.File;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verify {
	
	public boolean isTrue(String s) {
	
		Pattern regularString = Pattern.compile("\\s");//匹配空表达式
		Matcher m = regularString.matcher(s);
		if(m.find() == true){
			System.out.println("ERROR");
			System.out.println("#表达式为空");
			return false;
		}

		Pattern regularString1 = Pattern.compile("\\(\\)");//匹配空括号
		Matcher m1 = regularString1.matcher(s);
		if(m1.find() == true) {
			System.out.println("ERROR");
			System.out.println("#表达式中有空括号");
			return false;
		}
		
		Pattern regularString2 = Pattern.compile("([A-Za-z]|`|!|,|#|&|\\\\|:|;|<|>|%|=|\\$|\\.)");//匹配非法字符
		Matcher m2 = regularString2.matcher(s);
		if(m2.find() == true) {
			System.out.println("ERROR");
			System.out.println("#表达式包含非法字符");
			return false;
		}
		
		
		Stack var=new Stack();//括号不匹配情况
		char item;
		for(int i = 0;i < s.length();i++) {
			item = s.charAt(i);
			if(item == '(') {
				var.push(item);
			}
			else if(item == ')') {
				if(var.isEmpty() == false) {
					var.pop();
				}
				else {
					System.out.println("ERROR");
					System.out.println("#括号不匹配");
					return false;
				}
			}
			
		}
		 if(var.isEmpty() == false) {
			System.out.println("ERROR");
			System.out.println("#括号不匹配");
			return false;
		}
		
		Pattern regularString4 = Pattern.compile("[\\+\\-\\*\\/]{2,}");//运算符连续
		Matcher m4 = regularString4.matcher(s);
		if(m4.find() == true) {
			System.out.println("ERROR");
			System.out.println("#运算符连续");
			return false;
		}
		
		Pattern regularString5 = Pattern.compile("\\([\\+\\-\\*\\/]");//运算符前无运算数
		Matcher m5 = regularString5.matcher(s);
		if(m5.find() == true) {
			System.out.println("ERROR");
			System.out.println("#运算符前无运算数");
			return false;
		}
		
		Pattern regularString6 = Pattern.compile("[\\+\\-\\*\\/]\\)");//运算符后无运算数
		Matcher m6 = regularString6.matcher(s);
		if(m6.find() == true) {
			System.out.println("ERROR");
			System.out.println("#运算符后无运算数");
			return false;
		}
		
		else
			return true;
		
	}

}
