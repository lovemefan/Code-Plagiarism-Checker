package homework01;

import java.util.Stack;

public class Expression {
	String expression = "";
	float result;
	Expression(){
		
	}
	
	public static  int judgeExpression(String s){
		
		Stack<Character> operatorStack2 = new Stack<>();
		for (int i = 0 ; i < s.length() ; i++){
			if (s.charAt(i) == '('){
				operatorStack2.push(s.charAt(i));
			}
			if (s.charAt(i) == ')'){
				//operatorStack2.push(s.charAt(i));
				if (!operatorStack2.isEmpty()){
					operatorStack2.pop();
				}else{
					return 9;
				}
			}
		}
		if (!operatorStack2.isEmpty()){
			return 9;
		}else
			//System.out.println("ccc");
		
		
		
		if (s.equals("")){//表达式为空
			return 1;
		}else if (s.matches(".*\\(\\).*")){//表达式中有空括号
			return 2;
		}else if (s.matches(".*[!@#$%^&?<>,.\\\\|{}\\[\\]=\":[a-z[A-Z]]].*")){//表达式包含非法字符
			return 3;
		}else if (s.matches(".*[\\+\\-\\*\\/][\\+\\-\\*\\/].*")){//运算符连续
			return 4;
		}else if (s.matches(".*\\([\\+\\-\\*\\/].*")){//运算符前无运算数
			return 5;
		}else if (s.matches(".*[\\+\\-\\*\\/]\\).*")){//运算符后无运算数
			return 6;
		}else if (s.matches(".*\\d\\(.*")){//小括号前无运算符，括号非第一个字符
			return 7;
		}else if (s.matches(".*\\)\\d.*")){//小括号后无运算符，括号非最后一个字符
			return 8;
		}else{
			return 0;
		}
	}
	
	public static void compute(Stack<Float> operandStack,
			Stack<Character> operatorStack) {
		char operator = operatorStack.pop();  
		float data2 = operandStack.pop(); 
		float data1 = operandStack.pop();
		
		switch(operator){
			case '+':
				operandStack.push(data1 + data2);
				break;
			case '-':
				operandStack.push(data1 - data2);
				break;
			case '*':
				operandStack.push(data1 * data2);
				break;
			case '/':
				operandStack.push(data1 / data2);	
				break;
			default:
				;
		}
	
	}
	
	public static float result(String s){
		String result = "";
		for (int i = 0 ; i < s.length() ; i++){
			if (s.substring(i,i+1).matches("[\\+\\-\\*\\/()]")){//匹配到加减乘除括号
				result = result + " " + s.charAt(i) + " ";//之间加空格隔开
			}
			else
				result = result + s.charAt(i);
		}
		
		String[] a = result.split(" ");
		Stack<Float> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
	
		for (String e:a){
			if (e.length() == 0){		//过滤掉空格
				continue;
			}
			
			if (e.charAt(0) >= '0' && e.charAt(0) <= '9'){
				operandStack.push(Float.parseFloat(e));
				
			}else if (e.charAt(0) == '+' || e.charAt(0) == '-'){
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '-' || operatorStack.peek() == '+' || operatorStack.peek() == '/' || operatorStack.peek() == '*'))
					compute(operandStack, operatorStack);
				operatorStack.push(e.charAt(0)); 
				
			}else if (e.charAt(0) == '*' || e.charAt(0) == '/'){
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '/' || operatorStack.peek() == '*')) {
                    compute(operandStack, operatorStack);
                }
                operatorStack.push(e.charAt(0));  
			}else if (e.charAt(0) == '('){
				
				 operatorStack.push('(');
			}else if (e.charAt(0) == ')'){
				while (operatorStack.peek() != '(') {
                    compute(operandStack, operatorStack);    
                }
                operatorStack.pop(); 
			}
			
		}
		while (!operatorStack.isEmpty()) {
			compute(operandStack, operatorStack);
			
		}
		
		return operandStack.pop();

	}

}
