package bigexpriment1;
import java.util.*;
public class Standard {
	Standard(){		
	}
	public int pd(String s) {
		int k=0;
		k=bdsnull(s);
		if(k==0)
			return	k;
		k=bdsnullkh(s);
		if(k==0)
			return	k;
		k=illgalchar(s);
		if(k==0)
			return	k;
		k=khmatching(s);
		if(k==0)
			return	k;
		k=opretorcontinuity(s);
		if(k==0)
			return	k;
		k=nullopretor(s);
		if(k==0)
			return	k;
		k=opretornull(s);
		if(k==0)
			return	k;
		k=optnull(s);
		if(k==0)
			return	k;
		k=nullopt(s);
		if(k==0)
			return	k;
		return k;
	}
	public	int	bdsnull(String s) {//表达式为空
		if(s!=null) {
			return 1;
		}
		else {
			System.out.println("ERROR\n#表达式为空");
			return	0;
		}
	}
	public	int	bdsnullkh(String s) {//空括号
		for(int	i=0;i<s.length();i++) {
			if((s.charAt(i)=='(')&&(s.charAt(i+1)==')')) {
				System.out.println("ERROR\n#表达式中有空括号");
				return	0;
			}
		}
		return	1;		
	}
	//if((((s.charAt(i)<='9')&&(s.charAt(i)>='/'))&&((s.charAt(i)<='+')&&(s.charAt(i)>='('))&&(s.charAt(i)=='-')&&(s.charAt(i)=='=')))
	public int illgalchar(String s) {//判断非法字符
		for(int	i=0;i<s.length();i++) {
			if(!(((s.charAt(i)<='9')&&(s.charAt(i)>='/'))||((s.charAt(i)<='+')&&(s.charAt(i)>='('))||(s.charAt(i)=='-')||(s.charAt(i)=='='))) {
				System.out.println("ERROR\n#表达式中含有非法字符");
				return 0;
			}
		}
		return 1;
	}
	public int khmatching(String s) {//判断括号是否匹配
		LinkedList<Character> optr = new LinkedList<Character>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				optr.push(s.charAt(i));
			}
			else if(s.charAt(i)==')') {
				 if(optr.isEmpty()){//栈空
					System.out.println("ERROR\n#");
					return 0;
				}
				 else if(optr.peek()=='(') {
						optr.pop();
					}
			}
		}
		if(optr.isEmpty()) {
			return 1;
		}
		else {
			System.out.println("ERROR\n#");
			return 0;
		}
	}
	public int opretorcontinuity(String s) {//运算符连续
		for(int i=0;i<s.length()-1;i++) {
			if((s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/')&&(s.charAt(i+1)=='+'||s.charAt(i+1)=='-'||s.charAt(i+1)=='*'||s.charAt(i+1)=='/')) {
				System.out.println("ERROR\n#运算符连续");
				return 0;
			}
		}
		return 1;
	}
	public int nullopretor(String s) {//运算符前无运算数
		if(s.charAt(0)=='+'||s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/') {
			System.out.println("ERROR\n#运算符前无运算数");
			return 0;
		}
		for(int i=1;i<s.length();i++) {
			if((s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/')&&!((s.charAt(i-1)<='9'&&s.charAt(i-1)>='0')||s.charAt(i-1)==')')) {
				System.out.println("ERROR\n#运算符前无运算数");
				return 0;
			}
		}
		return 1;
	}
	public int opretornull(String s) {//运算符后无运算数
		if(s.charAt(s.length()-1)=='+'||s.charAt(s.length()-1)=='-'||s.charAt(s.length()-1)=='*'||s.charAt(s.length()-1)=='/') {
			System.out.println("ERROR\n#运算符后无运算数");
			return 0;
		}
		for(int i=0;i<s.length()-1;i++) {
			if((s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/')&&!((s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')||s.charAt(i+1)=='(')) {
				System.out.println("ERROR\n#运算符后无运算数");
				return 0;
			}
		}
		return 1;
	}
	public int nullopt(String s) {//小括号前无运算符且非第一个字符
		for(int i=1;i<s.length();i++) {
			if((s.charAt(i-1)<='9'&&s.charAt(i-1)>='0')&&s.charAt(i)=='(') {
				System.out.println("ERROR\n#小括号前无运算符");
				return 0;
			}
		}
		return 1;		
	}
	public int optnull(String s) {//小括号前无运算符且非第一个字符
		for(int i=0;i<s.length()-1;i++) {
			if((s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')&&s.charAt(i)==')') {
				System.out.println("ERROR\n#小括号后无运算符");
				return 0;
			}
		}
		return 1;		
	}
}
