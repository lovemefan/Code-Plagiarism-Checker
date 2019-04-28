public class GetResult {
	StackOfArray stack = new StackOfArray();
	public String RPN(String expression){
		String RPN = "";	//RPN后缀表达式
    	for(int i = 0;i < expression.length();i++){
    		if (expression.charAt(i) == '('){
    			RPN1(stack,expression.charAt(i));
   		}
    		 if(isNumber(expression.charAt(i))){
    			RPN= RPN2(expression.charAt(i),RPN);
            	}
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-'){
            	RPN = RPN3(expression.charAt(i),stack,RPN);
            }
  		if(expression.charAt(i) == '*' || expression.charAt(i) == '/'){
  			RPN = RPN4(expression.charAt(i),stack,RPN);
     }
		//碰到右括号弹栈至碰到最近的左括号的内容，之间的内容付给RPN，左括号弹栈
      if (expression.charAt(i) == ')'){
    	  RPN = RPN5(expression.charAt(i),stack,RPN);
    	}
    	}
    	//输出栈中所余的符号
    	RPN += ' ';
    	while (stack.top != -1){
    		RPN += (char)stack.array[stack.top];
    		stack.pop(stack);
    	}
    	return RPN;
    }
	
	//左括号直接进栈
	public void RPN1(StackOfArray stack,char c){
			stack.push(stack,c);
	}
	
	//数字直接输出，赋值给后缀表达式
	public String RPN2(char c,String RPN){
	    	RPN += (char)c; 
	    	return RPN;
	}
	
	//加减进栈的话,栈顶运算符号出栈
	public String RPN3(char c,StackOfArray stack,String RPN){
    	RPN += ' ';//说明:数字用空格分开以便calculateResult计算
    	while (stack.array[stack.top] == '*' || stack.array[stack.top] == '/'
    			||stack.array[stack.top] == '+' || stack.array[stack.top] == '-'){
    		RPN += (char)stack.array[stack.top];        
    		stack.pop(stack);
   	}
    	stack.push(stack,c);
    	return RPN;
    }
	
	//乘除进栈的话，如果栈顶运算符号是乘除则出栈
	public String RPN4(char c,StackOfArray stack,String RPN){
	RPN += ' ';//说明:数字用空格分开以便calculateResult计算(重点)
		while (stack.array[stack.top] == '*' || stack.array[stack.top] == '/'){
			RPN += (char)stack.array[stack.top];
    		stack.pop(stack);
		}
    	stack.push(stack,c);
    	return RPN;
	}
	
	//碰到右括号弹栈至碰到最近的左括号的内容，之间的内容付给RPN，左括号弹栈
	public String RPN5(char c,StackOfArray stack,String RPN){
	RPN += ' ';//说明:数字用空格分开以便calculateResult计算(重点)
	while (stack.array[stack.top] != '('){
		RPN += (char)stack.array[stack.top];
		stack.pop(stack);
	}
	//弹掉左括号
	stack.pop(stack);
	return RPN;
	}
	
    public double calculateResult(String RPN){
    	//result:计算的结果
    	double result = 0;
    	//str1:记住数字
    	String str1 = "";
    	//遍历后缀表达式，找出数字
    	for(int i = 0;i < RPN.length();i ++){
    		if(isNumber(RPN.charAt(i))){
    			str1 += RPN.charAt(i);
    		}
    		//数字进栈
    		else if(RPN.charAt(i) == ' ' && str1 != ""){
    			double number = Double.parseDouble(str1);
    			str1 = "";
    			stack.push(stack,number);
    		}
    		//遇到'+'做加法,结果入栈
    		else if(RPN.charAt(i) == '+'){
    			result = stack.pop(stack) + stack.pop(stack);
    			stack.push(stack, result);
    		}
    		//遇到'-'做减法,结果入栈
    		else if(RPN.charAt(i) == '-'){
    			double num1 = stack.pop(stack);
    			double num2 = stack.pop(stack);
    			result = num2 - num1;
    			stack.push(stack, result);
    		}
    		//遇到'*'做乘法,结果入栈
    		else if(RPN.charAt(i) == '*'){
    			result = stack.pop(stack) * stack.pop(stack);
    			stack.push(stack, result);
    		}
    		//遇到'/'做除法,结果入栈
    		else if(RPN.charAt(i) == '/'){
    			double num1 = stack.pop(stack);
    			double num2 = stack.pop(stack);
    			result = num2 / num1;
    			stack.push(stack, result);
    		}
    	}
    	//返回计算结果
    	return result;
    }
  //检查字符是否属于数字范围
    public boolean isNumber(char ch){
    	if (ch >= '0'  && ch <= '9'){
    		return true;
    	}
    	return false;
    }
}
