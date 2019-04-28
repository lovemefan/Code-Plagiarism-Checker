package work;

import java.util.Stack;

public class Calculatortest {
public static int test(String[] s,int i) {	//判断输入是否相同
		
		for(int j=i-1;j>=0;j--) {
				
			if(s[j].equals(s[i]))
				return 1;				
		}
		
		return 0;
	}
	
	public static int test1(String s){
		String regex1=".*[\\\\(][\\\\)].*";//空括号匹配
		//String regex2=".*[\\\\D&&[^+&&[^-&&[^*&&[^/&&[^(&&[^)]]]]]]].*";//非法字符
		String regex3=".*[+[-[*[/]]]]{2}.*";//运算符重复
		String regex4=".*[\\\\D&&[^)]][+[-[*[/]]]].*|[+[-[*[/]]]].*";//运算符前没有数字
		String regex5=".*[+[-[*[/]]]][\\\\D&&[^(]].*|.*[+[-[*[/]]]]";//运算符后没有数字
		String regex6=".*[^+&&[^-&&[^*&&[^/&&[^(]]]]][(].*";//括号前没有运算数
		String regex7=".*[)][^+&&[^-&&[^*&&[^/&&[^)]]]]].*";//括号后没有运算数
		//String regex8 = "\\))*\\((";
		
		if(s.matches("")) {//表达式为空
			return 1;
		}else if(s.matches(regex1)) {//表达式中有空括号
			return 2;
		}/*else if(s.matches(regex2)) {//非法字符
			return 3;
		}*/
		else if(s.matches(regex3)) {//运算符重复
			return 4;
		}
		else if(s.matches(regex4)) {//运算符前没有数字
			return 5;
		}
		else if(s.matches(regex5)) {//运算符后没有数字
			return 6;
		}
		else if(s.matches(regex6)) {//括号前没有运算数
			return 7;
		}
		else if(s.matches(regex7)) {//括号后没有运算数
			return 8;
		}
		return 0;
	}

	

	
public static int test2(String s) {	//括号不匹配
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			
			char c = s.charAt(i);
			if(c == '('){
				stack.push('(');
			}
			else if(c == ')'){
				
				if(!stack.isEmpty())
					stack.pop();
				else
					return 1;
			}
		}
		if(!stack.isEmpty())
			return 1;
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int test3(String s) {
		// TODO Auto-generated method stub

		if(s.matches(".*[\\D&&[^+&&[^-&&[^*&&[^/&&[^(&&[^)]]]]]]].*"))
			return 1;
		
		return 0;
		
	}

}
