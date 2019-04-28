public class GetResult {
	StackOfArray stack = new StackOfArray();
	public String RPN(String expression){
		String RPN = "";	//RPN��׺���ʽ
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
		//���������ŵ�ջ����������������ŵ����ݣ�֮������ݸ���RPN�������ŵ�ջ
      if (expression.charAt(i) == ')'){
    	  RPN = RPN5(expression.charAt(i),stack,RPN);
    	}
    	}
    	//���ջ������ķ���
    	RPN += ' ';
    	while (stack.top != -1){
    		RPN += (char)stack.array[stack.top];
    		stack.pop(stack);
    	}
    	return RPN;
    }
	
	//������ֱ�ӽ�ջ
	public void RPN1(StackOfArray stack,char c){
			stack.push(stack,c);
	}
	
	//����ֱ���������ֵ����׺���ʽ
	public String RPN2(char c,String RPN){
	    	RPN += (char)c; 
	    	return RPN;
	}
	
	//�Ӽ���ջ�Ļ�,ջ��������ų�ջ
	public String RPN3(char c,StackOfArray stack,String RPN){
    	RPN += ' ';//˵��:�����ÿո�ֿ��Ա�calculateResult����
    	while (stack.array[stack.top] == '*' || stack.array[stack.top] == '/'
    			||stack.array[stack.top] == '+' || stack.array[stack.top] == '-'){
    		RPN += (char)stack.array[stack.top];        
    		stack.pop(stack);
   	}
    	stack.push(stack,c);
    	return RPN;
    }
	
	//�˳���ջ�Ļ������ջ����������ǳ˳����ջ
	public String RPN4(char c,StackOfArray stack,String RPN){
	RPN += ' ';//˵��:�����ÿո�ֿ��Ա�calculateResult����(�ص�)
		while (stack.array[stack.top] == '*' || stack.array[stack.top] == '/'){
			RPN += (char)stack.array[stack.top];
    		stack.pop(stack);
		}
    	stack.push(stack,c);
    	return RPN;
	}
	
	//���������ŵ�ջ����������������ŵ����ݣ�֮������ݸ���RPN�������ŵ�ջ
	public String RPN5(char c,StackOfArray stack,String RPN){
	RPN += ' ';//˵��:�����ÿո�ֿ��Ա�calculateResult����(�ص�)
	while (stack.array[stack.top] != '('){
		RPN += (char)stack.array[stack.top];
		stack.pop(stack);
	}
	//����������
	stack.pop(stack);
	return RPN;
	}
	
    public double calculateResult(String RPN){
    	//result:����Ľ��
    	double result = 0;
    	//str1:��ס����
    	String str1 = "";
    	//������׺���ʽ���ҳ�����
    	for(int i = 0;i < RPN.length();i ++){
    		if(isNumber(RPN.charAt(i))){
    			str1 += RPN.charAt(i);
    		}
    		//���ֽ�ջ
    		else if(RPN.charAt(i) == ' ' && str1 != ""){
    			double number = Double.parseDouble(str1);
    			str1 = "";
    			stack.push(stack,number);
    		}
    		//����'+'���ӷ�,�����ջ
    		else if(RPN.charAt(i) == '+'){
    			result = stack.pop(stack) + stack.pop(stack);
    			stack.push(stack, result);
    		}
    		//����'-'������,�����ջ
    		else if(RPN.charAt(i) == '-'){
    			double num1 = stack.pop(stack);
    			double num2 = stack.pop(stack);
    			result = num2 - num1;
    			stack.push(stack, result);
    		}
    		//����'*'���˷�,�����ջ
    		else if(RPN.charAt(i) == '*'){
    			result = stack.pop(stack) * stack.pop(stack);
    			stack.push(stack, result);
    		}
    		//����'/'������,�����ջ
    		else if(RPN.charAt(i) == '/'){
    			double num1 = stack.pop(stack);
    			double num2 = stack.pop(stack);
    			result = num2 / num1;
    			stack.push(stack, result);
    		}
    	}
    	//���ؼ�����
    	return result;
    }
  //����ַ��Ƿ��������ַ�Χ
    public boolean isNumber(char ch){
    	if (ch >= '0'  && ch <= '9'){
    		return true;
    	}
    	return false;
    }
}
