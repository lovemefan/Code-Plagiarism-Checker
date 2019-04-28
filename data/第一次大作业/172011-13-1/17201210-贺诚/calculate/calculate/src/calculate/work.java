package calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class work {
	public char[] op = {'+','-','*','/','(',')'};
	public String[] strOp = {"+","-","*","/","(",")"};
	public boolean isDigit(char c){
		if(c>='0'&&c<='9'){
			return true;
		}
		return false;
	}
	public boolean isOp(char c){
		for(int i = 0;i < op.length;i++){
			if(op[i]==c){
				return true;
			}
		}
		return false;
	}
	public boolean isOp(String s){
		for(int i = 0;i < strOp.length;i++){
			if(strOp[i].equals(s)){
				return true;
			}
		}
		return false;
	}

	public List<String> Work(String str){
		List<String> list = new ArrayList<String>();
		char c;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < str.length();i++){
			c = str.charAt(i);
			if(isDigit(c)){
				sb.append(c);
				
			}
			if(isOp(c)){
				if(sb.toString().length()>0){
					list.add(sb.toString());
					sb.delete(0, sb.toString().length());
				}
				list.add(c+"");
			}
		}
		if(sb.toString().length()>0){
			list.add(sb.toString());
			sb.delete(0, sb.toString().length());
		}
		return list;
	}

	public List<String> InfixToPostfix(List<String> list){
		List<String>  Postfixlist = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<list.size();i++){
			
			String s = list.get(i);
			if(s.equals("(")){
				stack.push(s);
			}
			else if(s.equals("*")||s.equals("/")){
				stack.push(s);
			}
			else if(s.equals("+")||s.equals("-")){
				if(!stack.empty()){
					while(!(stack.peek().equals("("))){
						Postfixlist.add(stack.pop());
						if(stack.empty()){
							break;
						}
					}
					stack.push(s);
				}
				else{
					stack.push(s);
				}
			}
			else if(s.equals(")")){
				while(!(stack.peek().equals("("))){
					Postfixlist.add(stack.pop());
				}
				stack.pop();
			}
			else{
				Postfixlist.add(s);
			}
			if(i==list.size()-1){
				while(!stack.empty()){
					Postfixlist.add(stack.pop());
				}
			}
		}
		return Postfixlist;
	}

	public int doCal(List<String> list){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<list.size();i++){
			String s = list.get(i);
			int t=0;
			if(!isOp(s)){
			    t = Integer.parseInt(s);
				stack.push(t);
			}
			else{
				if(s.equals("+")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2+a1;
					stack.push(v);
				}
				else if(s.equals("-")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2-a1;
					stack.push(v);
				}
				else if(s.equals("*")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2*a1;
					stack.push(v);
				}
				else if(s.equals("/")){
					int a1 = stack.pop();
					int a2 = stack.pop();
					int v = a2/a1;
					stack.push(v);
				}
			}
		}
		return stack.pop();
	}
}

