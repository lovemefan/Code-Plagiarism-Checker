
public class Stack {
	int top = 0;
	int bottom = 0;
	double []s = new double[100];
	
	// 无参数构造
	public Stack(){
		
	}
	
	public Stack(int top,int bottom,double []s){
		this.top = top;
		this.bottom = bottom;
		this.s = s;
	}
	 
	// 判断栈是否为空
	public Boolean isEmpty(Stack stack){
        if(stack.top == -1){
            return true;
        }
        else{
            return false;
        }
    }
	
	// 判断栈是否已满
	public Boolean isFull(Stack stack){
        if(stack.top == stack.s.length){
            return true;
        }
        else{
            return false;
        }
    }
	
	// 判断是否为数字
    public boolean isDigit(char ch){
    	if (ch >= '0'  && ch <= '9'){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
	
    // 入栈
	public void stackPush(Stack stack,char ch){
		if(isFull(stack)){
			System.out.println("栈已满,无法入栈");
			System.exit(0);
		}
		else{
			stack.top ++;
			stack.s[stack.top] = ch;
		}
	}
	
	// 重载入栈(算结果)
	public void stackPush(Stack stack,double num){
		if(isFull(stack)){
			System.out.println("栈已满,无法入栈");
			System.exit(0);
		}
		else{
			stack.top ++;
			stack.s[stack.top] = num;
		}
	}
	
	// 出栈
	public double stackPop(Stack stack){
		double peek = 0;
		if(isEmpty(stack)){
			System.out.println("栈空异常");
			System.exit(0);
		}
		peek = stack.s[stack.top];
		stack.top --;
		return peek;
	}
}