package 大作业01;

import java.util.regex.Matcher; 
import java.util.regex.Pattern;

/*检验表达式类*/
public class CheckExpression {

	public void checkExp(String expression) {
		
		if(expression.matches("")) {//空表达式
			System.out.println("ERROR");
			System.out.println("#表达式为空"); 
		//	return 1;
		}
		
		Pattern pattern1 = Pattern.compile("\\(\\)");//空括号
		Matcher m1 = pattern1.matcher(expression);
		if(m1.find()) {	//若匹配到则返回ture,否则返回false
			System.out.println("ERROR");
			System.out.println("#表达式中有空括号");
		//	return 2;
		}
		
		Pattern pattern2 = Pattern.compile("[a-zA-Z[ _`~!@#$%^&=|{}':;',\\\\[\\\\].<>……&；：”“’。，、？]]");//非法字符
		Matcher m2 = pattern2.matcher(expression);
		if(m2.find()) {	//若匹配到则返回ture,否则返回false
			System.out.println("ERROR");
			System.out.println("#表达式包含非法字符");
		//	return 3;
		}
		
		Pattern pattern3 = Pattern.compile("[[+][-][*][/]]{2,}");//运算符连续
		Matcher m3 = pattern3.matcher(expression);
		if(m3.find()) {	//若匹配到则返回ture,否则返回false
			System.out.println("ERROR");
			System.out.println("#运算符连续");
		//	return 4;
		}
		//return 0;
	}
}
