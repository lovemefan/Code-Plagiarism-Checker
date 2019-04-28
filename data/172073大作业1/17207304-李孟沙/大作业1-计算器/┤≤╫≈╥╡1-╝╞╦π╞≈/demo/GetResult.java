package demo;


public class GetResult {
	
	StackOfArray stack = new StackOfArray();
	public String EXP(String expression){
		String  EXP = "";
    	for(int i = 0;i < expression.length();i++){//遍历表达式
    		if (expression.charAt(i) == '('){//遇到左括号
    			EXP1(stack,expression.charAt(i),EXP);
    		}
    		if(isNumber(expression.charAt(i))){//遇到数字
    			EXP= EXP2(expression.charAt(i),EXP);
            }
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-'){//遇到+或-
            	EXP = EXP3(expression.charAt(i),stack,EXP);
            }
            if(expression.charAt(i) == '*' || expression.charAt(i) == '/'){//遇到*或/
            	EXP = EXP4(expression.charAt(i),stack,EXP);
            }
            //碰到右括号弹栈，直至碰到最近的左括号
            if (expression.charAt(i) == ')'){
            	EXP = EXP5(expression.charAt(i),stack,EXP);
            }
    	}
    	//输出栈中所余的符号
    	EXP += ' ';
    	while (stack.top != -1){
    		EXP += (char)stack.array[stack.top];
    		stack.pop(stack);
    	}
    	return EXP;
    }
	
	//左括号直接进栈
	public void EXP1(StackOfArray stack,char c,String EXP){
		EXP += ' ';//数字用空格分开以便计算
		stack.push(stack,c);
	}
	
	//数字直接输出，赋值给后缀表达式
	public String EXP2(char c,String EXP){
		EXP += (char)c; 
	    return EXP;
	}
	
	//遇到加减,栈顶运算符号出栈
	public String EXP3(char c,StackOfArray stack,String EXP){
		EXP += ' ';
    	while (stack.array[stack.top] == '*' || stack.array[stack.top] == '/'
    			||stack.array[stack.top] == '+' || stack.array[stack.top] == '-'){
    		EXP += (char)stack.array[stack.top];        
    		stack.pop(stack);
    	}
    	stack.push(stack,c);
    	return EXP;
    }
	
	//遇到乘除，如果栈顶运算符号是乘除,则出栈
	public String EXP4(char c,StackOfArray stack,String EXP){
		EXP += ' ';
		while (stack.array[stack.top] == '*' || stack.array[stack.top] == '/'){
			EXP += (char)stack.array[stack.top];
    		stack.pop(stack);
		}
    	stack.push(stack,c);
    	return EXP;
	}
	
	//碰到右括号弹栈，直至碰到最近的左括号
	public String EXP5(char c,StackOfArray stack,String EXP){
		while (stack.array[stack.top] != '('){
			EXP += (char)stack.array[stack.top];
			stack.pop(stack);
		}
		//弹掉左括号
		stack.pop(stack);
		return EXP;
	}
	
    public double calculate(String EXP){
 
    	double result = 0;//result:计算的结果
    	String str1 = "";//str1:记住数字
    	//遍历后缀表达式，找出数字
    	for(int i = 0;i < EXP.length();i ++){
    		if(isNumber(EXP.charAt(i))){
    			str1 += EXP.charAt(i);
    		}
    		//数字进栈
    		else if(EXP.charAt(i) == ' ' && str1 != ""){
    			double number = Double.parseDouble(str1);
    			str1 = "";
    			stack.push(stack,number);
    		}
    		//遇到'+'做加法,结果入栈
    		else if(EXP.charAt(i) == '+'){
    			result = stack.pop(stack) + stack.pop(stack);
    			stack.push(stack, result);
    		}
    		//遇到'-'做减法,结果入栈
    		else if(EXP.charAt(i) == '-'){
    			double num1 = stack.pop(stack);
    			double num2 = stack.pop(stack);
    			result = num2 - num1;
    			stack.push(stack, result);
    		}
    		//遇到'*'做乘法,结果入栈
    		else if(EXP.charAt(i) == '*'){
    			result = stack.pop(stack) * stack.pop(stack);
    			stack.push(stack, result);
    		}
    		//遇到'/'做除法,结果入栈
    		else if(EXP.charAt(i) == '/'){
    			double num1 = stack.pop(stack);
    			double num2 = stack.pop(stack);
    			result = num2 / num1;
    			stack.push(stack, result);
    		}
    	}
    	//返回计算结果
    	return result;
    }
    
    //检查字符是否是数字
    public boolean isNumber(char ch){
    	if (ch >= '0'  && ch <= '9'){
    		return true;
    	}
    	return false;
    }
    
}