package Calculator;

import java.util.Stack;

class check {
	boolean c;
	check(String s,boolean ch){
		boolean check=true;
		//检测非法字符
		check=invalid(s,check);
		//判断空括号
		check=bracket(s,check);
		//括号不匹配
		check=brackets(s,check);
		//运算符连续
		check=operat(s,check);
		this.c=check;
	}
	//判断非法字符
	static boolean invalid(String s,boolean check) {
		boolean j=true;
		for(int i=0;i<s.length()&&j;i++) {
				if(Character.isDigit(s.charAt(i))) {
					continue;
				}
				else {
					switch(s.charAt(i)) {
					case '+':
						break;
					case '-':
						break;
					case '*':
						break;
					case '/':
						break;
					case '(':
						break;
					case ')':
						break;
					default:
						j=false;
						break;
				}
			}
		}
		if(j==false) {
			System.out.println("ERROR");
			System.out.println("#表达式包含非法字符");
			check=false;
		}
		return check;
	}
	
	static boolean bracket(String s,boolean check) {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				if(s.charAt(i+1)==')') {
					System.out.println("ERROR");
					System.out.println("#表达式中有空括号");
					check=false;
				}
			}
		}
		return check;
	}
	
	static boolean brackets(String s,boolean check) {
		boolean j=true;
		Stack<Character> sc = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch=='(')// 如果是左括号，放入栈中
            {
                sc.push(ch);
            } 
            else if (ch==')') {// 如果是右括号
                if (sc.empty()){ // 栈为空，栈头没有字符与右括号匹配
                    j=false;
                }
                // 栈不为空，栈头字符与右括号匹配
                else {
                	sc.pop();
                }
            }
        }
        if(!sc.isEmpty()||!j) {
        	System.out.println("ERROR");
        	System.out.println("#符号不匹配");
        	check=false;
        }
		return check;
	}
	//判断是否是运算符
	public static boolean operation(char s) {
		char OP[]={'+','-','*','/'};
		int i=0;
		while(i<4){
			if(s!=OP[i])
				i++;
			else
				return true;
		}
		return false;
}
	//判断运算符是否有连续
	static boolean operat(String s,boolean check) {
		for(int i=0;i<s.length()-1;i++) {
			if(operation(s.charAt(i))) {
				if(operation(s.charAt(i+1))) {
					System.out.println("ERROR");
					System.out.println("#运算符连续");
					check=false;
				}
			}
			if(s.charAt(i)=='(') {
				if(operation(s.charAt(i+1))) {
					System.out.println("ERROR");
					System.out.println("#小括号后无运算数,括号非最后一个字符");
					check=false;
				}
			}
			if(s.charAt(i)==')') {
				if(Character.isDigit(s.charAt(i+1))) {
					System.out.println("ERROR");
					System.out.println("#小括号后无运算数,括号非最后一个字符");
					check=false;
				}
			}
		}
		if(!Character.isDigit(s.charAt(0))) {
			System.out.println("ERROR");
			System.out.println("#运算符前无运算数");
			check=false;
		}
		if(operation(s.charAt(s.length()-1))){
			System.out.println("ERROR");
			System.out.println("#运算符后无运算数");
			check=false;
		}
		return check;	
	}
}