import java.io.*;
import java.nio.charset.Charset;
import java.util.Stack;

public class Check {
	private String s;
	
	Check(String s) {
		this.s=s;
	}
	
	public boolean judge() {
		FileOperation fo=new FileOperation();
		if(s.length()<=0) {
			fo.writeFile("#表达式为空");
			return false;
		}
		char[] chars=s.toCharArray();
		for(int i=0;i<chars.length-1;i++) {
			if(chars[i]=='('&&chars[i+1]==')') {
				fo.writeFile("#表达式中有空括号");
				return false;
			}
		}
		for(int i=0;i<chars.length;i++) {
			String str="0123456789+-/*()";
			boolean statue=str.contains(String.valueOf(chars[i]));
			if(statue) {
				continue;
			}else {
				fo.writeFile("#表达式包含非法字符");
				return false;
			}
		}
		Stack<String> operator=new Stack<String>();
		for(int i=0;i<chars.length;i++) {
			if(chars[i]=='(') {
				operator.push(String.valueOf(chars[i]));
			}else if(chars[i]==')') {
				if(operator.isEmpty()) {
					fo.writeFile("#括号不匹配");
					return false;
				}
				operator.pop();
			}
		}
		if(!operator.isEmpty()) {
			fo.writeFile("#括号不匹配");
			return false;
		}
		String str="+*-/";
		Stack<String> operator1=new Stack<String>();
		operator1=loop(chars,operator1);
		String st=operator1.pop();
		boolean statue=str.contains(st);
		if(statue) {
			fo.writeFile("#运算符前无运算数");
			return false;
		}
		while(!operator1.isEmpty()) {
			boolean statue1=str.contains(st);
			boolean statue4="(".contains(st);
			if(statue1) {
				if(operator1.isEmpty()) {
					fo.writeFile("#运算符后无运算数");
					return false;
				}
				String st1=operator1.pop();
				boolean statue2=str.contains(st1);
				boolean statue3=")".contains(st1);
				if(statue2) {
					fo.writeFile("#运算符连续");
					return false;
				}else if(statue3){
					fo.writeFile("#运算符后无运算数");
					return false;
				}else {
					st=st1;
				}
			}else if(statue4){
				String st2=operator1.pop();
				boolean statue5=str.contains(st2);
				if(statue5) {
					fo.writeFile("#运算符前无运算数");
					return false;
				}else {
					st=st2;
				}
			}else {
				st=operator1.pop();
			}
		}
		
		return true;
	}
	
	public Stack loop(char[]chars,Stack operator) {
		for(int i=chars.length-1;i>=0;i--) {
			operator.push(String.valueOf(chars[i]));
		}
		return operator;
	}
	
}
