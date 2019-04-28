import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class  ToPostfix {
	int m = 0;
	public ToPostfix(){
		
	}
	public  double toPostfix(String str1) {
		String[] str = new String[1000];
		str1 = Space(str1);//去除空格
		str1 = str1.replace("(-", "(0-");
		str1 = addZero(str1);//如果符号开头，则加0
		String str4 = predeal(str1);// 用#隔开	
		str4 = str4.replace("##", "#");
		String[] str2 = str4.split("#");// 分割成字符串数组
		str2 = change(str2);//去掉#
		MyStack stack = new MyStack();
		int n = str2.length;
		for (int i = 0; i < n; i++) {	
			 if (!str2[i].matches("[\\+|\\-|\\*|\\/|\\(|\\)]")) {// 判断是否是数字
					str[m++] = str2[i];
			}
			// 如果是运算符
			else {
				if (injudge(stack,str2[i])){// 如果运算符栈为空或者该运算符比栈顶运算符的优先级高的时候直接入栈
					stack.push(str2[i]);
				} else if (str2[i].trim().equals(")")) {// 当是右括号的时候
					while (!stack.peek().equals("(")) {
						str[m++] = stack.pop();
					}
					stack.pop();
				} 
				else if(injudge2(stack, str2[i])){
					stack.push(str2[i]);
					
				}
					else {// 优先级低于栈顶运算符的时候
					while (!stack.isEmpty() && getPriority(str2[i]) <= getPriority(stack.peek())) {
						str[m++] =stack.pop();
					}
					stack.push(str2[i]);
				}
			}
		}
		while (!stack.isEmpty()) {// 将栈中剩余符号放入后缀表达式
			str[m++] =stack.pop();
		}
		CountResult outcome = new CountResult();
		return outcome.counte(str,m);
	}
	public String Space(String s2){
		String s = "[^\\s]";
		String s1 = "";
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(s2);
		while (matcher.find()){
			s1 += matcher.group();
		}
		s2 = s1;
		return s2;
	}
	public String addZero(String s){
		if(!s.equals("")){
		if(s.charAt(0) == '-')
			s = "0"+s;
		}
	 return s;
 }
	public boolean injudge(MyStack stack,String s){//判断栈是否为空或者栈顶元素是否为"("
		boolean f = false;
		if(stack.isEmpty()|| stack.peek().equals("(")|| s.trim().equals("("))
			f = true;
		return f;
	}
	public boolean injudge2(MyStack stack,String str2){
		boolean f = false;
		if(!stack.isEmpty() && getPriority(str2) > getPriority(stack.peek()))
			f = true;
		return f;
	}
	
	public  String[] change(String[] str){//去除字符串数组中每个字符串的#
		String[] s;
		for(int i = 0;i <str.length;i++){
			if(str[i]!=" ")
				str[i] = str[i].replace("#","");
			
		}				
		return str;
	}
	public  int getPriority(String a) {// 判断字符优先级
		int priority = 0;
		switch (a) {
		case "+":
		case "-":
			priority = 2;
			break;
		case "*":
		case "/":
			priority = 3;
			break;
		}
		return priority;

	}

	public  String predeal(String s) {//分割字符串方法
		String result = "";	
		for (int i = 0; i < s.length(); i++) {				
		    if(s.charAt(i) == '+' || s.charAt(i) == '-'|| s.charAt(i) == '*' || s.charAt(i) == '/')
				result += "#" + s.charAt(i) + "#";
			else if(s.charAt(i) == '(' )
			
				result += s.charAt(i)+"#";
			
			else if( s.charAt(i) == ')')
				result += "#"+s.charAt(i);
			else
				result += s.charAt(i);
		}
		return result;
	}
}
