package BigWork;
import java.util.*;

public class Counter {
	private static Stack<Character> skC=new Stack<>();
	private static List<String> eqList=new ArrayList<>();
	private static Stack<Integer> skA=new Stack<>();
	private final static String Op="+-*/";
	
	
	public static int solv(String equation) {
		transToAfter(equation);
		skC.clear();
		skA.clear();
		int ans=0;
		for(int i=0;i<eqList.size();i++) {
			String temp=eqList.get(i);
			char ch=temp.charAt(0);
			if(ch>='0'&&ch<='9') {
				skA.push(Integer.parseInt(temp));
			}else {
				int b=skA.pop();
				int	a=skA.pop();
				switch (ch) {
				case '*':
					ans=a*b;
					break;
				case '/':
					ans=a/b;
					break;
				case '+':
					ans=a+b;
					break;
				case '-':
					ans=a-b;
					break;
				}
				skA.push(ans);
			}
		}
		return skA.peek();
	}
	public static List<String> transToAfter(String equation ) {
		if(equation==null)
			throw new NullPointerException();
		for(int i=0;i<equation.length();i++) {
			char ch=equation.charAt(i);
			if(ch>='0'&&ch<='9') { 
				String num="";
				while(ch>='0'&&ch<='9') {
					num+=ch;
					if(i+1>=equation.length())break;
					ch=equation.charAt(++i);
				}
				if(i<equation.length()-1)
					i=i-1;
				eqList.add(num);
			}else {
				if(Op.indexOf(ch)!=-1) {
					if(skC.isEmpty())
						skC.push(ch);
					else {
						char ci=skC.peek();
						if((ch=='*'||ch=='/')&&(ci=='+'||ci=='-')) {
							skC.push(ch);
						}else {
							while(!skC.empty()&&skC.peek()!='(') {
								eqList.add(String.valueOf(skC.pop()));
							}
							skC.push(ch);
						}
					}
				}
				else if(ch=='(') {
					skC.push(ch);
				}
				else if(ch==')') {
					char temp=skC.pop();
					while(temp!='(') {
					eqList.add(String.valueOf(temp));
					temp=skC.pop();
					}
				}
			}
			if(i==equation.length()-1) {
				while(!skC.empty()) {
					eqList.add(String.valueOf(skC.pop()));
				}
			}
		}
		return eqList;
	}
}