import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class check {
	public String str; 
	public check(){
		
	}
	public check(String str){
		this.str = str;
	}
	
	public int checking(){
		
		String pattern = "\\(\\-";//检测表达式中是否含有“（-”的格式


		String th = "(0-";//为修改负数格式错误准备
		String th1 = "0-";
		Pattern r = Pattern.compile(pattern);// 创建 Pattern 对象

	
		Matcher m = r.matcher(str);	// 现在创建 matcher 对象
		if (m.find()) {
			System.out.println("Found value: " + m.find() );
			
			str = m.replaceAll(th);//将所有“（-”替换成“（0-”格式
			System.out.println("replace:" + str );
			return 1;
			
		} 
		
		else if(Pattern.matches(".*[\\+\\-\\*\\/]\\).*",str)){//有运算符和右括号相连
			return 2;
		}
		
		else if(Pattern.matches(".*\\)[^\\+\\-\\*\\/].*",str)){//有右括号和运算符相连
			return 3;
		}
		else if(Pattern.matches(".*\\(\\).*",str)){//有左右括号相连
			return 4;
		}
		else if(Pattern.matches(".*\\([\\+\\*\\/].*",str)){//有左括号和除了-号的运算符相连
			return 5;
		}
		else if(Pattern.matches(".*[\\+\\-\\*\\/\\(\\)]{2,}.*",str)){//有重复的运算符或括号
			return 6;
		}
		else if(Pattern.matches(".*[^\\+\\-\\*\\/\\d+\\(\\)\\s].*",str)){//有除了运算符和数字的字符
			return 7;
		}
		else if(Pattern.matches(".*\\/0.*",str)){//有除0的算式
			return 8;
		}
		else if(Pattern.matches(".*0\\d+[\\+\\-\\*\\/\\)].*",str)){//0在数字之前
			return 9;
		}
		else if(str.charAt(0)=='+'||str.charAt(0)=='*'||str.charAt(0)=='/'||str.charAt(0)==')'){//开头第一位有除了“-”的运算符或右括号
			return 10;
		}
		else if(str.endsWith("-")||str.endsWith("+")||str.endsWith("*")||str.endsWith("/")||str.endsWith("(")){//结尾最后一位有算符或左括号
			return 11;
		}
		else if(Pattern.matches("str.charAt(0)=='-'",str)){//有运算符和右括号相连
			System.out.println("Found value: " + m.find() );
			str = m.replaceAll(th1);//将所有“（-”替换成“（0-”格式
			System.out.println("replace:" + str );
			return 12;
		}
		else {
			System.out.println("Found value:" + m.find());
			return 0;
		}

	

	}	
		
}
	

