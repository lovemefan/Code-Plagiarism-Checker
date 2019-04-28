package ooExperiment2;

import java.util.Stack;

public class PostToResult {
	private Stack<Integer> stack;//用于计算得到的栈
	
	public PostToResult(){
		
	}
	
	public PostToResult( Stack<Integer> stack){
		
		this.stack =stack;
	}
	
	//由后缀表达式得到的四则运算结果的实现过程
	public void operate(InfixToPost inf){
		String[] strArr = inf.getpost().split(" ");
		
		for(int i = 1;i < strArr.length; i++){
			
			String temp = strArr[i];
		
			if(isDigital(temp)){
				stack.push(Integer.valueOf(temp));
			}else{
				int result = compute(temp);
				stack.push(result);
			}
		}
	}
	public int compute(String str){
		int re = 0;
		int b = stack.pop();
		int a = stack.pop();
		switch(str){
		case "+" :
			re = a + b;
			break;
		case "-" :
			re = a - b;
			break;
		case "*" :
			re = a * b;
			break;
		case "/" :
			re = a / b;
			break;
		default :
			break;
		}
		return re;
	}
	public boolean isDigital(String str){
		char[] chArr = str.toCharArray();
		int len = chArr.length;
		int count = 0;
		for(int i =  0;i < len;i++){
			if(chArr[i] >= '0' && chArr[i] <= '9'){
				count++;
			}
		}
		return count == len;
	}
	public int getResult(){
		return stack.pop();
	}


}
