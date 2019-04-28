
public class Stack {
	int top = 0;
	int bottom = 0;
	double []s = new double[100];
	
	// �޲�������
	public Stack(){
		
	}
	
	public Stack(int top,int bottom,double []s){
		this.top = top;
		this.bottom = bottom;
		this.s = s;
	}
	 
	// �ж�ջ�Ƿ�Ϊ��
	public Boolean isEmpty(Stack stack){
        if(stack.top == -1){
            return true;
        }
        else{
            return false;
        }
    }
	
	// �ж�ջ�Ƿ�����
	public Boolean isFull(Stack stack){
        if(stack.top == stack.s.length){
            return true;
        }
        else{
            return false;
        }
    }
	
	// �ж��Ƿ�Ϊ����
    public boolean isDigit(char ch){
    	if (ch >= '0'  && ch <= '9'){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
	
    // ��ջ
	public void stackPush(Stack stack,char ch){
		if(isFull(stack)){
			System.out.println("ջ����,�޷���ջ");
			System.exit(0);
		}
		else{
			stack.top ++;
			stack.s[stack.top] = ch;
		}
	}
	
	// ������ջ(����)
	public void stackPush(Stack stack,double num){
		if(isFull(stack)){
			System.out.println("ջ����,�޷���ջ");
			System.exit(0);
		}
		else{
			stack.top ++;
			stack.s[stack.top] = num;
		}
	}
	
	// ��ջ
	public double stackPop(Stack stack){
		double peek = 0;
		if(isEmpty(stack)){
			System.out.println("ջ���쳣");
			System.exit(0);
		}
		peek = stack.s[stack.top];
		stack.top --;
		return peek;
	}
}