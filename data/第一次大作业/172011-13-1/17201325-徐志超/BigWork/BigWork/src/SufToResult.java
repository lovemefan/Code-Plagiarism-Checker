
public class SufToResult {
	public String suffix;
	public double res;
	
	// �޲�������
	public SufToResult(){
		
	}
	
	// ����
	public SufToResult(String suffix,double res){
		this.suffix = suffix;
		this.res = res;
	}
	
	// ��׺����
	public double getResult(String suffix){
		double res= 0;// ��ʼ�����
		Stack stack = new Stack();
		String s = "";
		
		for(int i = 0;i < suffix.length();i ++){
    		if(stack.isDigit(suffix.charAt(i))){// �ҳ�����
    			s = s + suffix.charAt(i);
    		}
    		else if(suffix.charAt(i) == ' ' && s != ""){// ��������֣���ջ
        			double number = Double.parseDouble(s);// ���ַ�ת����double��
        			s = "";
        			stack.stackPush(stack,number);
        	}
    		
    		else if(suffix.charAt(i) == '+'){ //�����Ӻ�
    			double a = stack.stackPop(stack);
    			double b = stack.stackPop(stack);
    			res = b + a;
    			stack.stackPush(stack, res);
    		}
    		else if(suffix.charAt(i) == '-'){ // ��������
    			double a = stack.stackPop(stack);
    			double b = stack.stackPop(stack);
    			res = b-a;
    			stack.stackPush(stack, res);
    		}
    		else if(suffix.charAt(i) == '*'){// �����˺�
    			double a = stack.stackPop(stack);
    			double b = stack.stackPop(stack);
    			res = b * a;
    			stack.stackPush(stack, res);
    		}
    		else if(suffix.charAt(i) == '/'){// ��������
    			double a = stack.stackPop(stack);
    			double b = stack.stackPop(stack);
    			res = b / a;
    			stack.stackPush(stack, res);
    		}
    	}
		return res;
	}
}
