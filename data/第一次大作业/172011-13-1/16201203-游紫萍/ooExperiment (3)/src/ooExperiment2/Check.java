package ooExperiment2;

import java.util.Stack;

public class Check {
	
public String match(String s) {
		
		Stack<Character> st = new Stack<Character>();//创建一个栈,栈内存字符
		
		
		
		String[] t = s.split(" ");//分离出字符串中的空格并将其余字符串存到字符串数组中         split()的用法
		
		String news = "";
		
	    for(int i = 0;i < t.length;i ++){//将字符中数组中字符串转换成一个字符串
	    	
	    	news += t[i];
	    }
	    
		//校验数学表达式
		String regex = "[\\(]*[1-9]+[\\)]*+(([\\+\\-\\*\\/]{1}[\\(]*[\\d]+)+[\\)]*)+";
				
		boolean match = news.matches(regex);
		
		//匹配括号
		if (match ) {
			char[] c = news.toCharArray();       //将字符串转换为字符数组   toCharArray()的用法
			for (int i = 0; i < c.length; i++) {
				if (c[i] == '(') {
					st.push(c[i]);          //遇到右括号，（ 进栈
				} else if (c[i] == ')') {      //遇到左括号
					if (st.isEmpty()) {          //栈为空则表达式不合法
						
						return "ERROR" + "\n" + "#括号不匹配";
						
					} else if (st.peek() == '(');  //栈不为空取出栈顶元素，栈顶元素为 （ ，则  （出栈
					st.pop();
				
				}
			}
			if (st.empty()) {           //循环结束，栈为空则数学表达式合法
				return "true";
			} else {
				
				return "ERROR" + "\n" + "#括号不匹配";
			}
		} else {
			
			return "ERROR" + "\n" + "#表达式不合法";
		}
		
	}
	//判断是否是数字
			public boolean isDigital(char ch){
				if (ch > '0' && ch < '9'){     //判断字符是否是数字
					return true;
				}else{
					return false;
				}
			}

}
