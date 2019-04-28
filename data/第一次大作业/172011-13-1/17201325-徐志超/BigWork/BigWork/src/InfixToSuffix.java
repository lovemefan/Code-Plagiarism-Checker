
public class InfixToSuffix {
	public String exp;
	public String suffix;
	
	//�޲�������
	public InfixToSuffix(){
		
	}
	
    // ����
	public InfixToSuffix(String exp,String suffix){
		this.exp = exp;
		this.suffix = suffix;
	}
	
	// ǰ׺ת��׺
	public String InfToSuf(String exp){
		String suffix = "";// ��ʼ����׺
		Stack stack = new Stack();

		for(int i = 0;i < exp.length();i ++){
			if (exp.charAt(i) == '('){ // ����������
    			stack.stackPush(stack,exp.charAt(i));
    		}
			
			else if(exp.charAt(i) == ')'){// ����������
				suffix += ' ';// �ӿո�(�������������������һλ��������λ��)
            	while (stack.s[stack.top] != '('){ // ֱ������������ѭ������
            		suffix += (char)stack.s[stack.top];
            		stack.stackPop(stack); // �������ڵĶ�����ջ
            	}
            	stack.stackPop(stack);//��������
            }
			
			else if(stack.isDigit(exp.charAt(i))){// ��������
            	suffix += exp.charAt(i);
            }
			
			else if((exp.charAt(i) == '+') || (exp.charAt(i) == '-' )){ // �����Ӽ�����
				// �Ƚ����ȼ����߼����ų�ջ��ͼ�������ջ
				suffix +=' ';
				suffix = change(stack,suffix);
            	suffix += ' ';
            	stack.stackPush(stack,exp.charAt(i));// �ӺŻ��߼��ŷ�����ջ
            }
			
			else if((exp.charAt(i) == '*') || (exp.charAt(i) == '/' )){ // �����˳�ֱ����ջ
				suffix += ' ';// �ӿո�
				stack.stackPush(stack,exp.charAt(i));
			}
		}
		
    	suffix += ' ';
    	suffix = shuchu(stack,suffix);
		return suffix; // ���غ�׺
	}
	
	// �Ƚ����ȼ����߼����ų�ջ��ͼ�������ջ
	public static String change(Stack stack,String suffix){
		int j = 0;
		while ((!stack.isEmpty(stack))&& (((stack.s[stack.top] == '*') || (stack.s[stack.top] == '/' )
    			|| (stack.s[stack.top] == '+' ) || (stack.s[stack.top] == '-' )))){
    		
    		if ((stack.s[stack.top] == '*') || (stack.s[stack.top] == '/' ) || j == 1){
    			suffix += (char)stack.s[stack.top];
        		stack.stackPop(stack);
        		j = 1;
    		}
		}
		return suffix;
	}
	
	public static String shuchu(Stack stack,String suffix){
		while (!stack.isEmpty(stack)){// ���ջ��ʣ��ķ���
			suffix += (char)stack.s[stack.top];
			stack.stackPop(stack);
		}
		return suffix;
	}
}
	

