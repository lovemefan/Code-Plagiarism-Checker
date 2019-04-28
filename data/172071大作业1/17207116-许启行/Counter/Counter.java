import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class Counter {
	String result;
	  Counter(String s){
		  this.result=Counter(s);
	  }
	  public String  Counter(String s) {
		ArrayList<String> L =transform(s);
		Stack<Integer> operand=new Stack<>();
		for(int i=0;i<L.size();i++) {
			if(Character.isDigit(L.get(i).charAt(0))) {
				operand.push(Integer.valueOf(String.valueOf(L.get(i))));
			}
			if(check.operation(L.get(i).charAt(0))) {
				int a=Integer.parseInt(String.valueOf(operand.pop()));
				int b=Integer.parseInt(String.valueOf(operand.pop()));
				int result=operate(a,L.get(i).charAt(0),b);
				operand.push(result);
			}
			if(L.get(i).charAt(0)=='('||L.get(i).charAt(0)==')') {
				continue;
			}
		}
		return operand.pop().toString();
	  }
	  
	  public int operate(int a,char theta,int b) {
		  int result;
		  
			switch(theta){
				case '+':
					result=a+b;
					break;
				case '-':
					result=b-a;
					break;
				case '*':
					result=a*b;
					break;
				default:
					result=b/a;
					break;
			}
			return result;
		
		  
	  }
	  
	  public String insetBlanks(String s) {
	        String result = "";
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
	                    s.charAt(i) == '+' || s.charAt(i) == '-'
	                    || s.charAt(i) == '*' || s.charAt(i) == '/')
	                result += " " + s.charAt(i) + " ";
	            else
	                result += s.charAt(i);
	        }
	        return result;
	    }
	
	
	  
	  
	  //将中缀表达式转化为后缀表达式
	  public  ArrayList<String> transform(String expre) {
		  ArrayList<String> list = new ArrayList<>();
		  Stack<Character> stack = new Stack<>();
		  expre = insetBlanks(expre);
	        String[] tokens = expre.split(" ");
	        for (String token : tokens) {
	        	if(token.length()==0) {
	        		continue;
	        	}
	        	else if (Character.isDigit(token.charAt(0))) {
				
					list.add(token);
				}
				else {
					if(stack.isEmpty()) {
						stack.push(token.charAt(0));
					}
					else {
						switch(precede(stack.peek(),token.charAt(0))) {
						case '<':
							stack.push(token.charAt(0));
							break;
						case '=':
							stack.pop();
							break;
						case '>':
							list.add(Character.toString(stack.pop()));
							stack.push(token.charAt(0));
							break;
						
						}
					}
				}
	        
	        }
	 
			for (int i = 0; i < expre.length(); i++) {
				
		}
			while(!stack.isEmpty()) {
				list.add(Character.toString(stack.pop()));
			}
			return list;
	  }
	
	static char precede(char a,char c)
	{
		   char[][] pre={
						{'>','>','<','<','<','>','>'},
						{'>','>','<','<','<','>','>'},
						{'>','>','>','>','<','>','>'},
						{'>','>','>','>','<','>','>'},
						{'<','<','<','<','<','=',' '},
						{'>','>','>','>',' ','>','>'},
						{'<','<','<','<','<',' ','='}
						};
			int row = 0,col=0;
			if(a=='+')
				row=0;
			else if(a=='-')
				row=1;
			else if(a=='*')
				row=2;
				else if(a=='/')
				row=3;
			else if(a=='(')
				row=4;
			else if(a==')')
				row=5;
			else if(a=='#')
				row=6;
			if(c=='+')
				col=0;
			else if(c=='-')
				col=1;
			else if(c=='*')
				col=2;
			else if(c=='/')
				col=3;
			else if(c=='(')
				col=4;
			else if(c==')')
				col=5;
			else if(c=='#')
				col=6;
			return pre[row][col]; 
	}
	
	
	int P(char n){
		int i=0;
		switch(n){
			case '+':
				i=0;
				break;
			case '-':
				i=1;
				break;
			case '*':
				i=2;
				break;
			case '/':
				i=3;
				break;
			case '(':
				i=4;
				break;
			case ')':
				i=5;
				break;
			case '#':
				i=6;
				break;
		}
		return i;
	}
		    
public static void main(String[] args) {
	String s = null;
	File f = new File("src\\test");
	s=read(f,s);
	if(f.length()==0) {	
		System.out.println("#表达式为空");
	}
	else {
		check x=new check(s);
		//运算
		Counter result=new Counter(s);
		System.out.println(result.result);
	}
	
	
}

//读取文件
static String read(File f,String s) {
	try (Scanner input = new Scanner(f);){
		while(input.hasNext()) {
			 s = input.next();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return s;
}

public static void writeFile(File f,String result) {
	try (PrintWriter output = new PrintWriter(new FileOutputStream(f,true));){
		output.println(result);					
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} 
}

}

class check {
	check(String s){
		//检测非法字符错误
		invalid(s);
		//判断空括号错误
		bracket(s);
		//括号不匹配错误
		brackets(s);
		//运算符连续错误
		operat(s);
	}
	//判断非法字符错误
	void invalid(String s) {
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
			System.out.println("#表达式包含非法字符");
		}
	}
	
	void bracket(String s) {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				if(s.charAt(i+1)==')') {
					System.out.println("#表达式中有空括号");
				}
			}
		}
	}
	
	void brackets(String s) {
		boolean j=true;
		Stack<Character> sc = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch=='(')// 如果是左括号，入栈
            {
                sc.push(ch);
            } 
            else if (ch==')') {// 如果是右括号
                if (sc.empty()){ // 栈为空，栈头没有字符与右括号匹配，显示错误
                    j=false;
                }
                // 栈不为空，栈头字符与右括号匹配
                else {
                	sc.pop();
                }
            }
        }
        if(!sc.isEmpty()||!j) {
        	System.out.println("#符号不匹配");
        }
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
	void operat(String s) {
		for(int i=0;i<s.length()-1;i++) {
			if(operation(s.charAt(i))) {
				if(operation(s.charAt(i+1))) {
					System.out.println("#运算符连续");
				}
			}
			if(s.charAt(i)=='(') {
				if(operation(s.charAt(i+1))) {
					System.out.println("#小括号后无运算数,括号非最后一个字符");
				}
			}
			if(s.charAt(i)==')') {
				if(Character.isDigit(s.charAt(i+1))) {
					System.out.println("#小括号后无运算数,括号非最后一个字符");
				}
			}
		}
		if(!Character.isDigit(s.charAt(0))) {
			System.out.println("#运算符前无运算数");
		}
		if(operation(s.charAt(s.length()-1))){
			System.out.println("#运算符后无运算数");
		}	
	}
}

