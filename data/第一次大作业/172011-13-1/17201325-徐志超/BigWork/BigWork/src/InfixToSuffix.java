
public class InfixToSuffix {
	public String exp;
	public String suffix;
	
	//无参数构造
	public InfixToSuffix(){
		
	}
	
    // 重载
	public InfixToSuffix(String exp,String suffix){
		this.exp = exp;
		this.suffix = suffix;
	}
	
	// 前缀转后缀
	public String InfToSuf(String exp){
		String suffix = "";// 初始化后缀
		Stack stack = new Stack();

		for(int i = 0;i < exp.length();i ++){
			if (exp.charAt(i) == '('){ // 碰到左括号
    			stack.stackPush(stack,exp.charAt(i));
    		}
			
			else if(exp.charAt(i) == ')'){// 碰到右括号
				suffix += ' ';// 加空格(后面计算结果可用于区分一位数还是两位数)
            	while (stack.s[stack.top] != '('){ // 直到碰到左括号循环结束
            		suffix += (char)stack.s[stack.top];
            		stack.stackPop(stack); // 把括号内的东西出栈
            	}
            	stack.stackPop(stack);//弹左括号
            }
			
			else if(stack.isDigit(exp.charAt(i))){// 碰到数字
            	suffix += exp.charAt(i);
            }
			
			else if((exp.charAt(i) == '+') || (exp.charAt(i) == '-' )){ // 碰到加减符号
				// 比较优先级，高级符号出栈后低级符号入栈
				suffix +=' ';
				suffix = change(stack,suffix);
            	suffix += ' ';
            	stack.stackPush(stack,exp.charAt(i));// 加号或者减号符号入栈
            }
			
			else if((exp.charAt(i) == '*') || (exp.charAt(i) == '/' )){ // 碰到乘除直接入栈
				suffix += ' ';// 加空格
				stack.stackPush(stack,exp.charAt(i));
			}
		}
		
    	suffix += ' ';
    	suffix = shuchu(stack,suffix);
		return suffix; // 返回后缀
	}
	
	// 比较优先级，高级符号出栈后低级符号入栈
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
		while (!stack.isEmpty(stack)){// 输出栈中剩余的符号
			suffix += (char)stack.s[stack.top];
			stack.stackPop(stack);
		}
		return suffix;
	}
}
	

