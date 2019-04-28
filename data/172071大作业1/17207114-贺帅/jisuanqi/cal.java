package jisuanqi;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;
import jisuanqi.calcheck;

class cal {
	String result;
	  cal(String s){
		  this.result=calcu(s);
	  }
	  public String  calcu(String s) {
		ArrayList<String> L =transform(s);
		Stack<Integer> op=new Stack<>();
		for(int i=0;i<L.size();i++) {
			if(Character.isDigit(L.get(i).charAt(0))) {
				op.push(Integer.valueOf(String.valueOf(L.get(i))));
			}
			if(calcheck.operation(L.get(i).charAt(0))) {
				int a=Integer.parseInt(String.valueOf(op.pop()));
				int b=Integer.parseInt(String.valueOf(op.pop()));
				int result=operate(a,L.get(i).charAt(0),b);
				op.push(result);
			}
			if(L.get(i).charAt(0)=='('||L.get(i).charAt(0)==')') {
				continue;
			}
		}
		return op.pop().toString();
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
		  ArrayList<String> l = new ArrayList<>();
		  Stack<Character> s = new Stack<>();
		  expre = insetBlanks(expre);
	        String[] tokens = expre.split(" ");
	        for (String token : tokens) {
	        	if(token.length()==0){
	        		continue;
	        	}
	        else if (Character.isDigit(token.charAt(0))) {
					// 如果是数字则存入List中
					l.add(token);
				}
				else {
					if(s.isEmpty()) {
						s.push(token.charAt(0));
					}
					else {
						switch(precede(s.peek(),token.charAt(0))) {
						case '<':
							s.push(token.charAt(0));
							break;
						case '=':
							s.pop();
							break;
						case '>':
							l.add(Character.toString(s.pop()));
							s.push(token.charAt(0));
							break;
						
						}
					}
				}
	        
	        }
	 
			for (int i = 0; i < expre.length(); i++) {
				
		}
			while(!s.isEmpty()) {
				l.add(Character.toString(s.pop()));
			}
			return l;
	  }
	  
	  int P(char n){//判断运算符在二维数组中的位置 
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
			    
	
	static char precede(char a,char c)
	{
		   char[][] pre={
						{'>','>','<','<','<','>','>'},
						{'>','>','<','<','<','>','>'},
						{'>','>','>','>','<','>','>'},
						{'>','>','>','>','<','>','>'},
						{'<','<','<','<','<','=',' '},
						{'>','>','>','>',' ','>','>'},
						{'<','<','<','<','<',' ','='}};
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
	
}	
	
