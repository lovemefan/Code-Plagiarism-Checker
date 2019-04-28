
public class SufToResult {
	public String suffix;
	public double res;
	
	// 无参数构造
	public SufToResult(){
		
	}
	
	// 重载
	public SufToResult(String suffix,double res){
		this.suffix = suffix;
		this.res = res;
	}
	
	// 后缀算结果
	public double getResult(String suffix){
		double res= 0;// 初始化结果
		Stack stack = new Stack();
		String s = "";
		
		for(int i = 0;i < suffix.length();i ++){
    		if(stack.isDigit(suffix.charAt(i))){// 找出数字
    			s = s + suffix.charAt(i);
    		}
    		else if(suffix.charAt(i) == ' ' && s != ""){// 如果是数字，进栈
        			double number = Double.parseDouble(s);// 把字符转换成double型
        			s = "";
        			stack.stackPush(stack,number);
        	}
    		
    		else if(suffix.charAt(i) == '+'){ //碰到加号
    			double a = stack.stackPop(stack);
    			double b = stack.stackPop(stack);
    			res = b + a;
    			stack.stackPush(stack, res);
    		}
    		else if(suffix.charAt(i) == '-'){ // 碰到减号
    			double a = stack.stackPop(stack);
    			double b = stack.stackPop(stack);
    			res = b-a;
    			stack.stackPush(stack, res);
    		}
    		else if(suffix.charAt(i) == '*'){// 碰到乘号
    			double a = stack.stackPop(stack);
    			double b = stack.stackPop(stack);
    			res = b * a;
    			stack.stackPush(stack, res);
    		}
    		else if(suffix.charAt(i) == '/'){// 碰到除号
    			double a = stack.stackPop(stack);
    			double b = stack.stackPop(stack);
    			res = b / a;
    			stack.stackPush(stack, res);
    		}
    	}
		return res;
	}
}
