package ooExperiment2;

import java.util.Stack;

//中缀转后缀的类
public class InfixToPost {
	
	private Stack<String> stack; //中缀表达式转化为后缀表达式需要的栈
	
	private String post ; //存储得到的后缀表达式
	
	public InfixToPost(){
		
	}
 
	//初始化构造器
	public InfixToPost( Stack<String> stack,String post) {
		this.stack=stack;
	
		this.post = post;
	}
	
	//将中缀表达式转化为后缀表达式的过程
	public void  process(String express) {
		  
		String[] strArr = express.split(" ");//分割字符串，遇到空隔分割一次；分割出来的字符串存到String数组中
		for (int i = 0; i < strArr.length; i++){
			switch (strArr[i]){
			case "+":
			case "-":
				getOperation(strArr[i], 1);
				break;
			case "*":
			case "/":
				getOperation(strArr[i], 2);
				break;
			case "(":
				stack.push(strArr[i]);
				break;
			case ")":
				getParent();
				break;
			default:
				
				post +=  " "+strArr[i];     //遇到数字字符串就输出
				break;	
			}
		}
		
		//数字全部输出后需要输出栈中剩余符号
		while (!stack.isEmpty()) {
			
			post +=  " "+ stack.pop();
		}
	}
	
	public void getOperation(String str, int priorit ){
		while (!stack.isEmpty()){
			String top =stack.pop();
			if(top.equals("(")){
				stack.push(top);
				break;
			}else {
				int priTop = getPriority(top);
				if (priTop < priorit) {
					stack.push(top);
					break;
				}else {
					post += " "+ top;
				}
			}
		}
		stack.push(str);
	}
	public int getPriority(String str) {
		int pri = 0;
		if (str.equals("+") || str.equals("-")){
			pri = 1;
		} else {
			pri = 2;
		}
		return pri;
	}
	public void getParent() {
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")){
				break;
			} else {
				post += " "+ top;
			}
		}
	}

	public String getpost() {
		return post;
	}
	
}
