package 大作业;

import java.io.File;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YanZhen {
	
	public boolean isTrue(String s) {
	
		Pattern regularString = Pattern.compile("\\s");//匹配空表达式
		Matcher m = regularString.matcher(s);
		if(m.find() == true){
			System.out.println("ERROR");
			System.out.println("#表达式为空");
			return false;
		}

		Pattern regularString1 = Pattern.compile("\\(\\)");//匹配空括号
		Matcher n1 = regularString1.matcher(s);
		if(n1.find() == true) {
			System.out.println("ERROR");
			System.out.println("#表达式中有空括号");
			return false;
		}
		
		Pattern regularString2 = Pattern.compile("([A-Za-z]|`|!|,|#|&|\\\\|:|;|<|>|%|=|\\$|\\.)");//匹配非法字符
		Matcher n2 = regularString2.matcher(s);
		if(n2.find() == true) {
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
		Matcher n4 = regularString4.matcher(s);
		if(n4.find() == true) {
			System.out.println("ERROR");
			System.out.println("#运算符连续");
			return false;
		}
		
		Pattern regularString5 = Pattern.compile("\\([\\+\\-\\*\\/]");//运算符前无运算数
		Matcher n5 = regularString5.matcher(s);
		if(n5.find() == true) {
			System.out.println("ERROR");
			System.out.println("#运算符前无运算数");
			return false;
		}
		
		Pattern regularString6 = Pattern.compile("[\\+\\-\\*\\/]\\)");//运算符后无运算数
		Matcher n6 = regularString6.matcher(s);
		if(n6.find() == true) {
			System.out.println("ERROR");
			System.out.println("#运算符后无运算数");
			return false;
		}
		//[0-9[+][-][*][/]]*[0-9][(][0-9[+][-][*][/]]*"
		Pattern regularString7 = Pattern.compile("[0-9\\+\\-\\*\\/]*[0-9][(][0-9\\+\\-\\*\\/]*");
		Matcher n7 = regularString7.matcher(s);
		if(n7.find() == true) {
			System.out.println("ERROR");
			System.out.println("#括号非第一个字符,且之前无运算符");
			return false;
		}
		
		Pattern regularString8 = Pattern.compile("[0-9\\+\\-\\*\\/]*[)][0-9][0-9\\+\\-\\*\\/]*");
		Matcher n8 = regularString8.matcher(s);
		if(n8.find() == true) {
			System.out.println("ERROR");
			System.out.println("#小括号后无运算符，括号非最后一个字符");
			return false;
		}
		
		else
			return true;
		
	}

}
